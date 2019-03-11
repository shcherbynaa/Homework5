package com.mateanna.hw5;

import jdk.dynalink.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Calculator {

    private static Map<Character, BinaryOperator<Double>> operations() {
        BinaryOperator<Double> sum = (x, y) -> x + y;
        BinaryOperator<Double> multiply = (x, y) -> x * y;
        BinaryOperator<Double> divide = (x, y) -> x / y;
        BinaryOperator<Double> substract = (x, y) -> x - y;
        BinaryOperator<Double> root = (x, y) -> (x / (1 / y));
        BinaryOperator<Double> power = (x, y) -> (Math.pow(x, (1 / y)));
        BinaryOperator<Double> power117 = (x, y) -> ((Math.pow(((x + y) / x + 117), y)));

        Map<Character, BinaryOperator<Double>> operatorMap = new HashMap<>();
        operatorMap.put('+', sum);
        operatorMap.put('*', multiply);
        operatorMap.put('/', divide);
        operatorMap.put('-', substract);
        operatorMap.put('#', root);
        operatorMap.put('^', power);
        operatorMap.put('p', power117);

        return operatorMap;
    }

    public double calculate(double x, char operator, double y) throws NullPointerException {
        BinaryOperator<Double> op = operations().get(operator);
        return op.apply(x, y);
    }
}
