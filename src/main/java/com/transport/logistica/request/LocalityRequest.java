package com.transport.logistica.request;

import com.transport.logistica.dto.LocalityDTO;
import lombok.val;
import org.springframework.web.client.RestTemplate;

public class LocalityRequest {

    public LocalityDTO execute(final String cep) throws Exception {

        val urlCall = buildUrl(cep);

        try {

            val rest = new RestTemplate();
            val responseLocality = rest.getForEntity(urlCall, LocalityDTO.class);

            if (!responseLocality.getStatusCode().is2xxSuccessful()){
                throw new RuntimeException("Http error code: " + responseLocality.getStatusCode());
            }

            return responseLocality.getBody();

        }   catch (Exception e){

            throw new Exception("ERROR: "+ e);
        }
    }

    private String buildUrl(String cep) {

        val urlCepInit = "https://viacep.com.br/ws/";
        val json = "/json/";

        return urlCepInit + cep + json;
    }
}
