package com.transport.logistica.mapper;

import com.transport.logistica.dto.LocalityDTO;
import com.transport.logistica.model.LocalityEntity;

public interface StructMapper {

    LocalityEntity toLocalityModel(LocalityDTO localityDTO);
}
