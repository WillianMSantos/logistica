package com.transport.logistica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalityDTO {

    @JsonProperty(value = "cep")
    private String cep;

    @JsonProperty(value = "logradouro")
    private String publicPlace;

    @JsonProperty(value = "complemento")
    private String complement;

    @JsonProperty(value = "bairro")
    private String district;

    @JsonProperty(value = "localidade")
    private String locality;

    @JsonProperty(value = "uf")
    private String uf;

    @JsonProperty(value = "ibge")
    private String ibge;

    @JsonProperty(value = "gia")
    private String gia;

    @JsonProperty(value = "ddd")
    private String ddd;

    @JsonProperty(value = "siafi")
    private String siafi;
}
