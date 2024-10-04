package com.proyectosjuan.gestionpizzas.service;

import com.proyectosjuan.gestionpizzas.persistence.entity.PizzaEntity;
import com.proyectosjuan.gestionpizzas.persistence.repository.PizzaPagSortRepository;
import com.proyectosjuan.gestionpizzas.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaPagSortRepository = pizzaPagSortRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public Page<PizzaEntity> getAllPizzas(int page, int size){
        Sort sort = Sort.by(Sort.Order.desc("price"));
        Pageable pageable = PageRequest.of(page, size, sort);
        return pizzaPagSortRepository.findAll(pageable);
    }

    public PizzaEntity getPizzaById(Integer id){
        return pizzaRepository.findById(id).orElse(null);
    }

    public PizzaEntity createPizza(PizzaEntity pizza){
        return pizzaRepository.save(pizza);
    }

    public boolean exist(int idPizza){
        return this.pizzaRepository.existsById(idPizza);
    }

    public void deletePizza(int idPizza){
        this.pizzaRepository.deleteById(idPizza);
    }

    public List<PizzaEntity> getAllAvailablePizzas(){
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public PizzaEntity getPizzaByName(String name){
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public List<PizzaEntity> getPizzasByDescription(String description){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getPizzasByNotDescription(String description){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
    }

    public PizzaEntity getFirstPizzaByName(String name){
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("Pizza not found"));

    }

    public List<PizzaEntity> getTreePizzasByPrice(Double price){
        return this.pizzaRepository.findFirst3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    @Transactional
    public void updatePrice(int id, Double price){
        this.pizzaRepository.updatePrice(id, price);
    }

}
