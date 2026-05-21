package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client;

import lombok.Getter;

/**
 * Enumeration, für welche Fabasoft Objektklasse eine Suche durchgeführt werden soll (Abstraktion für FROM-Klausel)
 */
@Getter
public enum FabasoftObjectClass {

  AKTE("DEPRECONFIG@15.1001:SubjectAreaFile"),
  VORGANG("DEPRECONFIG@15.1001:Procedure"),
  ATTRIBUT_DEFINITION("COOSYSTEM@1.1:AttributeDefinition");

  private final String fabasoftClassSpecfier;

  FabasoftObjectClass(String fabasoftClassSpecfier) {
    this.fabasoftClassSpecfier = fabasoftClassSpecfier;
  }

}