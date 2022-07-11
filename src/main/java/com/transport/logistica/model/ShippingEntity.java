package com.transport.logistica.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@Table(name = "TB_SHIPPING")
@NoArgsConstructor
@AllArgsConstructor
public class ShippingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "CEP_ORIGIN")
    private String cepOrigin;

    @Column(name = "CEP_DESTINY")
    private String cepDestiny;

    @Column(name = "NAME_RECIPIENT")
    private String nameRecipient;

    @Column(name = "VALUE_TOTAL")
    private double valueTotalShipping;

    @Column(name = "EXPECT_DELIVERY_DATE")
    private LocalDate expectedDeliveryDate;

    @Column(name = "CONSULTATION_DATE")
    private LocalDate consultationDate;
}
