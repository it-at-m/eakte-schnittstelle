package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.BenutzerRolle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface BenutzerMapper {
    @Mapping(source = "rollen", target = "rollen")
    de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Benutzer fromDomain(Benutzer user);

    @Mapping(source = "organisationseinheit", target = "organisationseinheit")
    @Mapping(source = "stelle", target = "stelle")
    @Mapping(source = "mandant", target = "mandant")
    @Mapping(source = "isDefault", target = "_default")
    BenutzerRolle fromDomain(Benutzer.Rolle user);
}
