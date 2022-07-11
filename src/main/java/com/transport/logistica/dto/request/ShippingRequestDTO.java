package com.transport.logistica.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingRequestDTO {

    private double weight;
    private String cepOrigin;
    private String cepDestiny;
    private String name;
}
