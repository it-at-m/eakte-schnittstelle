package de.muenchen.dms.listen.readprocedureobjectsmetadata;

import de.muenchen.dms.common.model.BusinessObjectReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadProcedureObjectsMetaDataResponseDTO {
    @Schema(description = "Liste der Dokumente mit Metadaten eines Vorgangs auslesen",
    example = "BusinessObjectType")
    private List<BusinessObjectReference> businessobjecttype;
}
