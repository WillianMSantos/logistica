package com.transport.logistica.mapper;

import com.transport.logistica.dto.LocalityDTO;
import com.transport.logistica.model.LocalityEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LocalityMapper implements StructMapper {

    @Override
    @Transactional
    public LocalityEntity toLocalityModel(LocalityDTO localityDTO) {
        return LocalityEntity.builder()
                .cep(localityDTO.getCep())
                .complement(localityDTO.getComplement())
                .locality(localityDTO.getLocality())
                .ddd(localityDTO.getDdd())
                .district(localityDTO.getDistrict())
                .gia(localityDTO.getGia())
                .ibge(localityDTO.getIbge())
                .publicPlace(localityDTO.getPublicPlace())
                .siafi(localityDTO.getSiafi())
                .uf(localityDTO.getUf())
                .build();
    }
}
