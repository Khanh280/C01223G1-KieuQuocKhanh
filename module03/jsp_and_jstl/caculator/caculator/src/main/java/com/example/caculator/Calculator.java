package com.example.caculator;

public class Calculator {
    public static String calculate(float firstOperator, float secondOperator, String operator) throws ArithmeticException {
        String result = null;
        switch (operator){
            case "+":
                result = String.valueOf(firstOperator + secondOperator);
                break;
            case "-":
                result = String.valueOf(firstOperator - secondOperator);
                break;
            case "*":
                result = String.valueOf(firstOperator * secondOperator);
                break;
            case "/":
                if(secondOperator == 0){
                    throw new  ArithmeticException("ERROR");
                }else {
                    result = String.valueOf(firstOperator / secondOperator);
                }
                break;
        }
        return result;
    }

}
