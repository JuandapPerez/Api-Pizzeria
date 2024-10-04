package com.proyectosjuan.gestionpizzas.service;

import com.proyectosjuan.gestionpizzas.persistence.entity.CustomerEntity;
import com.proyectosjuan.gestionpizzas.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

}
