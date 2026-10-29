package de.muenchen.dms.listen.readsubjectareaobjectsmetadata;

import de.muenchen.dms.common.model.BusinessObjectReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReadSubjectAreaObjectsMetaDataResponseDTO {
  @Schema(
      description = "Liste der Sachakten mit Metadaten eines Aktenplaneintrags auslesen",
      example = "BusinessObjectType")
  private List<BusinessObjectReference> businessobjecttype;
}
