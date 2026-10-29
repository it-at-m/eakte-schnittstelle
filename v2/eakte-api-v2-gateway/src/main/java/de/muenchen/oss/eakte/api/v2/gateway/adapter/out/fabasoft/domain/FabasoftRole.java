package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FabasoftRole {
    SACHBEARBEITUNG("COO.1.1001.1.4328"),
    SCHRIFTGUTVERWALTUNG("COO.15.1400.1.28120"),
    REGISTRATUR("COO.1.1001.1.4329"),
    SEKRETARIAT("COO.1.1001.1.4592"),
    LEITUNG("COO.1.1001.1.4595"),
    FACHADMINISTRATION("COO.15.1400.1.28012");

    private final String id;
}
