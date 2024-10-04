package com.proyectosjuan.gestionpizzas.web.controller;


import com.proyectosjuan.gestionpizzas.persistence.entity.OrderEntity;
import com.proyectosjuan.gestionpizzas.service.OrderService;
import com.proyectosjuan.gestionpizzas.service.dto.RandomOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(this.orderService.getAllOrders());
    }

    @GetMapping("/afterDate")
    public ResponseEntity<List<OrderEntity>> getOrdersAfterDate(){
        return ResponseEntity.ok(this.orderService.getOrdersAfterDate());
    }

    @GetMapping("/byMethod")
    public ResponseEntity<List<OrderEntity>> getOrdersByMethod(){
        return ResponseEntity.ok(this.orderService.getOrdersByMethod());
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String idCustomer){
        return ResponseEntity.ok(this.orderService.getCustomerOrders(idCustomer));
    }
    @PostMapping("/random")
    public ResponseEntity<Boolean> saveRandomOrder(@RequestBody RandomOrderDto randomOrderDto){
        return ResponseEntity.ok(this.orderService.saveRandomOrder(randomOrderDto));
    }
}
