package com.suafata.order.service;

import com.suafata.order.domain.entity.Pizza;
import com.suafata.order.excepetion.PizzaException;
import org.springframework.stereotype.Component;

@Component
public interface PizzaService {

    Pizza getPizzaByName(String s) throws PizzaException;
}
