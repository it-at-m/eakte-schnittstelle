package de.muenchen.dms.signature.set;

public class SetSignatureDTOBeispiel {
  public static SetSignatureRequestDTO erzeugeSetSignature() {
    return SetSignatureRequestDTO.builder()
        .signaturetype("COO.15.1700.1.64522")
        .remark("String")
        .build();
  }
}
