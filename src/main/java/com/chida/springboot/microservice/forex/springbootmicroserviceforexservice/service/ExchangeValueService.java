package com.chida.springboot.microservice.forex.springbootmicroserviceforexservice.service;

import com.chida.springboot.microservice.forex.springbootmicroserviceforexservice.domain.ExchangeValue;

public interface ExchangeValueService {
    ExchangeValue findByFromAndToCurrency(String from, String to);
}
