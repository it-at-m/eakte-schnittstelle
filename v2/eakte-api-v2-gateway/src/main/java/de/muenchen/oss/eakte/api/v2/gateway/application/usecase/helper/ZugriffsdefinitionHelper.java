package de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.MetadataEntry;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class ZugriffsdefinitionHelper {
    private final SearchOutPort searchOutPort;
    private static List<MetadataEntry> zugriffsdefinitionen;

    public ZugriffsdefinitionHelper(final SearchOutPort searchOutPort) {
        this.searchOutPort = searchOutPort;
        zugriffsdefinitionen = this.loadZugriffsdefinitionen();
    }

    private List<MetadataEntry> loadZugriffsdefinitionen() {
        log.info("Loading Zugriffsdefinitionen");
        final SearchRequest request = new SearchRequest(FabasoftType.ZUGRIFFSDEFINITION, null, SearchRequest.LIMIT_MAX, null, Set.of());
        // TODO user permissions
        final SearchResult result = searchOutPort.searchObject(new RequestContext(null, null, null), request);
        log.info("Loaded {} Zugriffsdefinitionen", result.results().size());
        return result.results().stream().map(i -> new MetadataEntry(i.name(), i.coo())).toList();
    }

    public static String textToId(final String text) {
        return zugriffsdefinitionen.stream().filter(i -> i.text().equals(text))
                .findFirst().orElseThrow().fabasoftId();
    }

    public static String idToText(final String id) {
        return zugriffsdefinitionen.stream().filter(i -> i.fabasoftId().equals(id))
                .findFirst().orElseThrow().text();
    }
}
