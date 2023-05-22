package com.calculate.service.impl;

import com.calculate.service.ICaculateService;
import org.springframework.stereotype.Service;

@Service
public class CaculateServiceImpl implements ICaculateService {
    @Override
    public float caculate(float firstValue, float secondValue, String operator) {
        float result = 0;
        switch (operator) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "x":
                result = firstValue * secondValue;
                break;
            case "/":
                result = firstValue / secondValue;
                break;
            default:
                result =0;
        }
        return result;
    }
}
