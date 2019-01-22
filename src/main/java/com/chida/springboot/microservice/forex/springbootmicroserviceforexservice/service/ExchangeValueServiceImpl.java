package com.chida.springboot.microservice.forex.springbootmicroserviceforexservice.service;

import com.chida.springboot.microservice.forex.springbootmicroserviceforexservice.domain.ExchangeValue;
import com.chida.springboot.microservice.forex.springbootmicroserviceforexservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService{

    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    public ExchangeValueServiceImpl(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @Override
    public ExchangeValue findByFromAndToCurrency(String from, String to) {
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}

