package de.muenchen.dms.common.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserFormsReferenz {
  @JsonProperty("LHMBAI_15_1700_ufreference")
  @JsonAlias({
    "LHMBAI_15_1700_ufreference",
    "lHMBAI_15_1700_ufreference",
    "lhmbai_15_1700_ufreference"
  })
  private String LHMBAI_15_1700_ufreference;

  @JsonProperty("LHMBAI_15_1700_ufvalue")
  @JsonAlias({"LHMBAI_15_1700_ufvalue", "lHMBAI_15_1700_ufvalue", "lhmbai_15_1700_ufvalue"})
  private List<String> LHMBAI_15_1700_ufvalue;
}
