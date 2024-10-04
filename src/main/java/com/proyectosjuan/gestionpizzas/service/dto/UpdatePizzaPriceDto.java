package com.proyectosjuan.gestionpizzas.service.dto;

import lombok.Data;

@Data
public class UpdatePizzaPriceDto {
    private int pizzaId;
    private Double newPrice;

}
