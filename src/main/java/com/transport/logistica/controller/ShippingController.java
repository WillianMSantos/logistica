package com.transport.logistica.controller;

import com.transport.logistica.dto.request.ShippingRequestDTO;
import com.transport.logistica.dto.response.ShippingResponseDTO;
import com.transport.logistica.model.ShippingEntity;
import com.transport.logistica.service.ShippingService;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Integer registerShipping(@RequestBody ShippingRequestDTO shippingRequestDTO) throws Exception {

      ShippingEntity shipping = service.registerShipping(shippingRequestDTO);
      return shipping.getId();
    }

    @GetMapping("/{id}")
    public ShippingResponseDTO findShipping(@PathVariable Integer id) {

       return service.findShipping(id);
    }

    @GetMapping("/list-shipping")
    public List<ShippingResponseDTO> listAll() {

        return service.findAll();
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteShipping(@PathVariable Integer id) {
        service.deleteShipping(id);

        return "Shipping delete success";
    }

}
