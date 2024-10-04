package com.proyectosjuan.gestionpizzas.persistence.repository;

import com.proyectosjuan.gestionpizzas.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity,Integer> {
}
