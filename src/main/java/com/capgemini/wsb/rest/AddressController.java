package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController
{

    private final AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/{id}")
    AddressTO findBaId(@PathVariable final Long id) {
        final AddressTO address = addressService.findById(id);
        if(address != null)
        {
            return address;
        }
        throw new EntityNotFoundException(id);
    }
}
