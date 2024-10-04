package com.proyectosjuan.gestionpizzas.web.controller;

import com.proyectosjuan.gestionpizzas.persistence.entity.PizzaEntity;
import com.proyectosjuan.gestionpizzas.service.PizzaService;
import com.proyectosjuan.gestionpizzas.service.dto.UpdatePizzaPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<Page<PizzaEntity>> getAllPizzas(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "8") int size){
        return ResponseEntity.ok(this.pizzaService.getAllPizzas(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaEntity> getPizzaById(@PathVariable Integer id){
        return ResponseEntity.ok(this.pizzaService.getPizzaById(id));
    }

    @PostMapping()
    public ResponseEntity<PizzaEntity> createPizza(@RequestBody PizzaEntity pizza){
         if(pizza.getIdPizza() == null /*|| !this.pizzaService.exist(pizza.getIdPizza())*/){
             return ResponseEntity.ok(this.pizzaService.createPizza(pizza));
         }
         return ResponseEntity.badRequest().build();
    }

    @PutMapping()
    public ResponseEntity<PizzaEntity> updatePizza(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() != null && this.pizzaService.exist(pizza.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.createPizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Integer id){
        if(this.pizzaService.exist(id)){
            this.pizzaService.deletePizza(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAllAvailablePizzas(){
        return ResponseEntity.ok(this.pizzaService.getAllAvailablePizzas());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getPizzaByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.getPizzaByName(name));
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<PizzaEntity>> getPizzasByDescription(@PathVariable String description){
        return ResponseEntity.ok(this.pizzaService.getPizzasByDescription(description));
    }

    @GetMapping("/not_description/{description}")
    public ResponseEntity<List<PizzaEntity>> getPizzasByNotDescription(@PathVariable String description){
        return ResponseEntity.ok(this.pizzaService.getPizzasByNotDescription(description));
    }

    @GetMapping("/first/{name}")
    public ResponseEntity<PizzaEntity> getFirstPizzaByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.getFirstPizzaByName(name));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<PizzaEntity>> getTreePizzasByPrice(@PathVariable Double price){
        return ResponseEntity.ok(this.pizzaService.getTreePizzasByPrice(price));
    }

    @PutMapping("/updatePrice")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaPriceDto updatePizzaPriceDto){
        this.pizzaService.updatePrice(updatePizzaPriceDto.getPizzaId(), updatePizzaPriceDto.getNewPrice());
        return ResponseEntity.ok().build();
    }

}
