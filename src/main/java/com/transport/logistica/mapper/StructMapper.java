package com.transport.logistica.mapper;

import com.transport.logistica.request.object.LocalityObject;
import com.transport.logistica.dto.request.ShippingRequestDTO;
import com.transport.logistica.dto.response.ShippingResponseDTO;
import com.transport.logistica.model.LocalityEntity;
import com.transport.logistica.model.ShippingEntity;

public interface StructMapper {

    ShippingResponseDTO toShippingDto(ShippingEntity shippingEntity);
}
