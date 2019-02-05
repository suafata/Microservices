package com.suafata.order.domain.repository;

import com.suafata.order.domain.entity.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
    Pizza findByName(String name);
}
