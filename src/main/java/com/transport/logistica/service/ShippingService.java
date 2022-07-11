package com.transport.logistica.service;

import com.transport.logistica.dto.request.ShippingRequestDTO;
import com.transport.logistica.dto.response.ShippingResponseDTO;
import com.transport.logistica.mapper.StructMapper;
import com.transport.logistica.model.ShippingEntity;
import com.transport.logistica.repository.ShippingRepository;
import com.transport.logistica.request.LocalityRequest;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ShippingService {

    private ShippingRepository shippingRepository;
    private StructMapper structMapper;

    public ShippingEntity registerShipping(ShippingRequestDTO requestDTO) throws Exception {

        val cepOrigin = verifyCepValid(requestDTO.getCepOrigin());
        val cepDestiny = verifyCepValid(requestDTO.getCepDestiny());

        requestDTO.setCepOrigin(cepOrigin);
        requestDTO.setCepDestiny(cepDestiny);

        ShippingEntity shippingToSave = new ShippingEntity();
        double valueTotal = valueShipping(requestDTO);

        shippingToSave.setCepOrigin(requestDTO.getCepOrigin());
        shippingToSave.setCepDestiny(requestDTO.getCepDestiny());
        shippingToSave.setWeight(requestDTO.getWeight());
        shippingToSave.setNameRecipient(requestDTO.getName());
        shippingToSave.setValueTotalShipping(valueTotal);

        return shippingRepository.save(shippingToSave);
    }


    private double valueShipping(ShippingRequestDTO requestDTO) throws Exception {

        val localityOrigin = new LocalityRequest().execute(requestDTO.getCepOrigin());
        val localityDestiny = new LocalityRequest().execute(requestDTO.getCepDestiny());

        val responseDTO = new ShippingResponseDTO();

        responseDTO.setCepOrigin(localityOrigin.getCep());
        responseDTO.setCepDestiny(localityDestiny.getCep());

        if(Objects.equals(localityOrigin.getDdd(), localityDestiny.getDdd())) {

            double valueTotal = calculateShipping(requestDTO.getWeight(), 0.50);
            responseDTO.setValueTotalShipping(valueTotal);

            return responseDTO.getValueTotalShipping();

        }else if(Objects.equals(localityOrigin.getUf(), localityDestiny.getUf())) {

            double valueTotal = calculateShipping(requestDTO.getWeight(), 0.75);
            responseDTO.setValueTotalShipping(valueTotal);

            return responseDTO.getValueTotalShipping();

        }else if(!Objects.equals(localityOrigin.getUf(), localityDestiny.getUf())) {

            double valueTotal = buildValueWeight(requestDTO.getWeight());
            responseDTO.setValueTotalShipping(valueTotal);

            return responseDTO.getValueTotalShipping();
        }

        return responseDTO.getValueTotalShipping();
    }

    public ShippingResponseDTO findShipping(Integer id) {

        val shipping = verifyExistShipping(id);
        return structMapper.toShippingDto(shipping);
    }

    private ShippingEntity verifyExistShipping(Integer id) {
        return shippingRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Shipping not found"));
    }

    public List<ShippingResponseDTO> findAll() {
        List<ShippingEntity> allShipping = shippingRepository.findAll();
        return allShipping.stream()
                .map(structMapper::toShippingDto)
                .collect(Collectors.toList());
    }

    private double calculateShipping(double value, double percent) {

        double valueWeight = buildValueWeight(value);
        return discount(valueWeight, percent);
    }

    public void deleteShipping(Integer id) {

        shippingRepository.findById(id)
                .map(shipping -> {

                    shippingRepository.delete(shipping);
                    return Void.TYPE;}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Shipping not found for id"));
    }


    private double discount(double value, double percent) {
        return value*percent;
    }


    //verifica validade do CEP
    private String verifyCepValid(String cep) throws Exception {

        val localityCep = new LocalityRequest().execute(cep);
        return localityCep.getCep();
    }

    //valor por peso
    private double buildValueWeight(double weight) {

        val valueByWeight = 1.00;
        return weight*valueByWeight;
    }
}
