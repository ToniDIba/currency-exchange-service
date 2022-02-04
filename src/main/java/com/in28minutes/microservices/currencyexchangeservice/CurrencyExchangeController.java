package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.core.env.Environment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {


    @Autowired
    private Environment env;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        System.out.println("Paso por el 8000");
        //ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(Long.parseLong("65")));
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

        exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port"))); //El que tienes declarado en tu properties
        return exchangeValue;
    }

}
