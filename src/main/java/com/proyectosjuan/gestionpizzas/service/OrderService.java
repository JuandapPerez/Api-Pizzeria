package com.proyectosjuan.gestionpizzas.service;

import com.proyectosjuan.gestionpizzas.persistence.entity.OrderEntity;
import com.proyectosjuan.gestionpizzas.persistence.repository.OrderRepository;
import com.proyectosjuan.gestionpizzas.service.dto.RandomOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderEntity> getOrdersAfterDate() {
        LocalDateTime date = LocalDate.of(2023,1,1).atTime(0,0);
        return orderRepository.findAllByDateAfter(date);
    }

    public List<OrderEntity> getOrdersByMethod() {
        return orderRepository.findAllByMethodIn(List.of(DELIVERY, CARRYOUT));
    }

    public List<OrderEntity> getCustomerOrders(String idCustomer) {
        return orderRepository.findCustomerOrders(idCustomer);
    }

    @Transactional
    public boolean saveRandomOrder(RandomOrderDto randomOrderDto) {
        return orderRepository.saveRandomOrder(randomOrderDto.getIdCustomer(), randomOrderDto.getMethod());
    }

}
