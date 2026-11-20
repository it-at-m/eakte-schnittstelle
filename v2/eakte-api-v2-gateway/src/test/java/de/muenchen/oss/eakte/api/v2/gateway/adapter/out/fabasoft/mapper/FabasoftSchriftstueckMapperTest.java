package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SchriftstueckAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;

class FabasoftSchriftstueckMapperTest {
    private final FabasoftSchriftstueckMapper mapper = new FabasoftSchriftstueckMapper(new FabasoftAttributeMapperImpl());

    @Test
    void givenResultObject_thenMapSchriftstueck() {
        final ResultObject result = new ResultObject("name", "coo", List.of(
                attribute(SchriftstueckAttribute.DOKUMENT_ID, "dokument"),
                attribute(SchriftstueckAttribute.BETREFF, "subject"),
                attribute(SchriftstueckAttribute.DATEI_ENDUNG, "pdf"),
                attribute(SchriftstueckAttribute.DATEI_GROESSE, BigInteger.valueOf(1234))));

        final SchriftstueckResponse mapped = mapper.toDomain(result);

        assertEquals("coo", mapped.id());
        assertEquals("dokument", mapped.dokumentId());
        assertEquals("name", mapped.name());
        assertEquals("subject", mapped.betreff());
        assertEquals("pdf", mapped.dateiEndung());
        assertEquals(BigInteger.valueOf(1234), mapped.dateiGroesse());
    }

    @Test
    void givenResults_thenMapEachResult() {
        final ResultObject result = new ResultObject("name", "id", List.of(
                attribute(SchriftstueckAttribute.DOKUMENT_ID, "dokument")));

        assertEquals(List.of(mapper.toDomain(result)), mapper.toDomain(List.of(result)));
    }

    private static FabasoftAttribute attribute(final SchriftstueckAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}
