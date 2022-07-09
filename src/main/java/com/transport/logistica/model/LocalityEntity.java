package com.transport.logistica.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_LOCATION")
public class LocalityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "PUBLIC_PLACE")
    private String publicPlace;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "LOCALITY")
    private String locality;

    @Column(name = "UF")
    private String uf;

    @Column(name = "IGBE")
    private String ibge;

    @Column(name = "GIA")
    private String gia;

    @Column(name = "DDD")
    private String ddd;

    @Column(name = "SIAFI")
    private String siafi;
}
