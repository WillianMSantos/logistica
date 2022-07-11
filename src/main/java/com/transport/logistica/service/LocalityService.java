package com.transport.logistica.service;

import com.transport.logistica.request.object.LocalityObject;
import com.transport.logistica.mapper.StructMapper;
import com.transport.logistica.repository.LocalityRepository;
import com.transport.logistica.request.LocalityRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LocalityService {

    private LocalityRepository localityRepository;
    private StructMapper structMapper;

    public LocalityObject findRequestLocalityApiCep(String cep) throws Exception {

        return new LocalityRequest().execute(cep);
    }
}
