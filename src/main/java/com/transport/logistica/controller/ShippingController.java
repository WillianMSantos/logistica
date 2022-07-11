package com.transport.logistica.controller;

import com.transport.logistica.dto.request.ShippingRequestDTO;
import com.transport.logistica.dto.response.ShippingResponseDTO;
import com.transport.logistica.model.ShippingEntity;
import com.transport.logistica.service.ShippingService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/shipping")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ShippingController {

    private ShippingService service;

    @PostMapping("/register")
    @ApiOperation("Registra um frete")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer registerShipping(@RequestBody ShippingRequestDTO shippingRequestDTO) throws Exception {

      ShippingEntity shipping = service.registerShipping(shippingRequestDTO);
      return shipping.getId();
    }

    @GetMapping("/{id}")
    @ApiOperation("Pesquisa frete pelo ID")
    public ShippingResponseDTO findShipping(@PathVariable Integer id) {

       return service.findShipping(id);
    }

    @GetMapping("/list-shipping")
    @ApiOperation("Carrega todos os fretes")
    public List<ShippingResponseDTO> listAll() {

        return service.findAll();
    }

    @DeleteMapping("/{id}/delete")
    @ApiOperation("Exclui um frete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteShipping(@PathVariable Integer id) {
        service.deleteShipping(id);

        return "Shipping delete success";
    }

}
