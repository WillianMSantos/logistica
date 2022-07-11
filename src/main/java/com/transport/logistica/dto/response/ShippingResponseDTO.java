package com.transport.logistica.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingResponseDTO {

    private double valueTotalShipping;
    //private LocalDateTime expectedDeliveryDate;
    private String cepOrigin;
    private String cepDestiny;
}
