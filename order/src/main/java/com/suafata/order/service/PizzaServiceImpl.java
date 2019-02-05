package com.suafata.order.service;

import com.suafata.order.domain.entity.Pizza;
import com.suafata.order.domain.repository.PizzaRepository;
import com.suafata.order.excepetion.PizzaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Pizza getPizzaByName(String s) throws PizzaException {
        Pizza pizza = pizzaRepository.findByName(s);

        if(pizza == null) {
            throw new PizzaException(String.format("The Pizza %s doesn't exist", s));
        }

        return pizza;
    }
}
