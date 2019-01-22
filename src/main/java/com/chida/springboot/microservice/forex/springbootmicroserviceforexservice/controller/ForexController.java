package com.chida.springboot.microservice.forex.springbootmicroserviceforexservice.controller;

import com.chida.springboot.microservice.forex.springbootmicroserviceforexservice.domain.ExchangeValue;
import com.chida.springboot.microservice.forex.springbootmicroserviceforexservice.service.ExchangeValueService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {
    private Environment environment;
    private ExchangeValueService exchangeValueService;

    public ForexController(Environment environment, ExchangeValueService exchangeValueService) {
        this.environment = environment;
        this.exchangeValueService = exchangeValueService;
    }


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExhangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueService.findByFromAndToCurrency(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
