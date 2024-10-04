package com.proyectosjuan.gestionpizzas.persistence.repository;

import com.proyectosjuan.gestionpizzas.persistence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<PizzaEntity> findFirst3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(Double price);

    @Modifying
    @Query(value = "UPDATE pizza SET price = :price WHERE id_pizza = :id ", nativeQuery = true)
    void updatePrice(@Param("id")int id, @Param("price")Double price);

    default PizzaEntity findAllByAvailableTrueAndReplace(String name) {
        return findAllByAvailableTrueAndNameIgnoreCase(name.replaceAll("\\s+", ""));
    }

}
