package com.proyectosjuan.gestionpizzas.web.controller;

import com.proyectosjuan.gestionpizzas.persistence.entity.CustomerEntity;
import com.proyectosjuan.gestionpizzas.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/byPhone/{phone}")
    public ResponseEntity<CustomerEntity> getCustomerByPhone(@PathVariable String phone){
        return ResponseEntity.ok(this.customerService.findByPhone(phone));
    }


}
