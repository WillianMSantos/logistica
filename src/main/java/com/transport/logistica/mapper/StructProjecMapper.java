package com.transport.logistica.mapper;
import com.transport.logistica.dto.response.ShippingResponseDTO;
import com.transport.logistica.model.ShippingEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StructProjecMapper implements StructMapper {

    @Override
    @Transactional
    public ShippingResponseDTO toShippingDto(ShippingEntity shippingEntity) {
        return ShippingResponseDTO.builder()
                .cepOrigin(shippingEntity.getCepOrigin())
                .cepDestiny(shippingEntity.getCepDestiny())
                .valueTotalShipping(shippingEntity.getValueTotalShipping())
                .expectedDeliveryDate(shippingEntity.getExpectedDeliveryDate())
                .build();
    }
}
