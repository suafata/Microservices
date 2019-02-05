package com.suafata.order.controller;

import com.suafata.order.domain.entity.Pizza;
import com.suafata.order.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.suafata.order.RestMapping.PIZZA;

@RestController
@RequestMapping(value = PIZZA)
public class PizzaController {

    private static Logger LOGGER = LoggerFactory.getLogger(PizzaController.class);
    private PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
        LOGGER.info("Initializing controller");
    }

    @GetMapping("/getByName")
    public Pizza getPizzaByName(@RequestParam String name){
        return pizzaService.getPizzaByName(name);
    }

}
