package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements ICurrencyService{
    @Override
    public int currencyVnd(int usd, int rate) {
        return usd * rate;
    }
}
