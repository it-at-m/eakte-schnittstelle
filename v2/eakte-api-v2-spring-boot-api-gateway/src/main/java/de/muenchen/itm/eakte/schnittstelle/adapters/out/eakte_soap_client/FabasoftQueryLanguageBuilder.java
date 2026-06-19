package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Attributbeschreibung;
import io.vavr.Function1;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
public class FabasoftQueryLanguageBuilder {

  private final List<Attributbeschreibung> attributbeschreibungen;

  private static final Pattern DOLLAR_PLACEHOLDER = Pattern.compile("\\$\\{([^}]+)}");
  private static final Pattern HASH_PLACEHOLDER = Pattern.compile("#\\{([^}]+)}");

  /**
   * liefert die (kryptische/interne) Attributreferenz von Fabasoft, wenn als
   * "Makro" entweder die Bezeichnung des Attributs oder die URI angegeben werden
   *
   * @param makroSpecifier Text innerhalb der Zeichen-Sequenz "${...}" der Suchbedingungen
   * @return aufgelöste Fabasoft-Referenz oder makroSpecifier selbst, falls nichts gefunden
   */
  public String resolve(String makroSpecifier) {
    // könnte bei Performance-Problemen auch mit Maps auf die einzelnen Such-Felder umgesetzt werden:
    Optional<String> value = attributbeschreibungen.stream()
      .filter((Attributbeschreibung ab) ->
        makroSpecifier.equalsIgnoreCase(ab.getBezeichnung()) ||
          ab.getEigeneUrl().isPresent() && makroSpecifier.equalsIgnoreCase(ab.getEigeneUrl().get())
      )
      .map(Attributbeschreibung::getReferenzAttribut)
      .findFirst();
    log.trace("Resolved makro specifier \"" + makroSpecifier + "\" to \"" + value + "\"");
    if (value.isEmpty()) {
      throw new RuntimeException("Platzhalter-Text \"" + makroSpecifier + "\" konnte nicht in Attributbeschreibungen aufgelöst werden. Verfügbare Platzhalter-Texte:" +
        attributbeschreibungen.stream().map(Attributbeschreibung::getBezeichnung).collect(Collectors.joining(",")));
    }
    return value.get();
  }

  private String extractInternalKeyFromUrl(String url) {
    return url.substring(url.lastIndexOf("/") + 1);
  }

  private String interpolate(String template, Pattern placeHolderPattern, Function1<String, String> mapperFunction) {
    Matcher matcher = placeHolderPattern.matcher(template);
    StringBuilder result = new StringBuilder();
    while (matcher.find()) {
      String key = matcher.group(1);
      String value = mapperFunction.apply(key);
      matcher.appendReplacement(result, Matcher.quoteReplacement(value));
    }
    matcher.appendTail(result);
    return result.toString();
  }

  public String createQueryString(FabasoftObjectClass fabasoftObjectClass, Optional<String> bedingungen,
                                  Optional<String> zusatzBedingungen, Optional<Integer> limit, boolean nocheck) {
    StringBuilder query = new StringBuilder();
    if (nocheck) {
      query.append("NOCHECK\n");
    }
    if (limit.isPresent()) {
      query.append("LIMIT 3000\n");
    }
    query.append("SELECT COOSYSTEM@1.1:objname\n")
      .append("FROM " + fabasoftObjectClass.getFabasoftClassSpecfier() + "\n");
    boolean bedingungenGegeben = bedingungen.isPresent() && !bedingungen.get().isEmpty();
    boolean zusatzBedingungenGegeben = zusatzBedingungen.isPresent() && !zusatzBedingungen.get().isEmpty();
    if (bedingungenGegeben || zusatzBedingungenGegeben) {
      String kompletteBedingungen;
      if (bedingungenGegeben && zusatzBedingungenGegeben) {
        kompletteBedingungen = "(" + bedingungen.get() + ") AND (" + zusatzBedingungen.get() + ")";
      } else {
        // nur eines von beiden oder gar keine, also keine Klammerung und kein AND nötig:
        kompletteBedingungen = bedingungen.orElse("") + zusatzBedingungen.orElse("");
      }
      query.append("WHERE\n");
      // replace generic attribute specifiers with the Fabasoft reference:
      String transformedWhereClause1 = interpolate(kompletteBedingungen, DOLLAR_PLACEHOLDER, this::resolve);
      // replace URLs with the extracted COO Address (should not happen on client; Url might be encoded in the future:
      String transformedWhereClause2 = interpolate(transformedWhereClause1, HASH_PLACEHOLDER, this::extractInternalKeyFromUrl);
      query.append("  "); // indent where clause content
      query.append(transformedWhereClause2);
    }
    return query.toString();
  }

  private static final String tab8 = "        ";

  public String createFullSoapRequest(String query, List<String> attrList) {
    String indentedQuery = Arrays.stream(query.split("\n")).map(l -> tab8 + l).collect(Collectors.joining("\n", "", "\n"));
    String indentedAttrList = attrList.stream().map(ar -> tab8 + "<urn:attr>" + ar + "</urn:attr>").collect(Collectors.joining("\n", "", "\n"));
    return
      """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                          xmlns:fsc="http://schemas.fabasoft.com/websvc/FSCGOVXML_1_1001_DefaultWebServiceDefinition/"
                          xmlns:urn="urn:schemas-fabasoft-com:bai:search">
          <soapenv:Body>
            <urn:SOAPSearchRequest>
              <urn:query>
        """ +
        indentedQuery +
        """          
                </urn:query>
                <urn:attrlist>
          """ +
        indentedAttrList +
        """        
                </urn:attrlist>
              </urn:SOAPSearchRequest>
            </soapenv:Body>
          </soapenv:Envelope>
          """;
  }
}
