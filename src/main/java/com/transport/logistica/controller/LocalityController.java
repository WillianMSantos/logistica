package com.transport.logistica.controller;

import com.transport.logistica.dto.LocalityDTO;
import com.transport.logistica.service.LocalityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/locality")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LocalityController {

    private LocalityService localityService;

    @GetMapping("/{cep}")
    public LocalityDTO findWeb(@PathVariable String cep) throws Exception {

        return localityService.findRequestLocalityApiCep(cep);
    }
}
