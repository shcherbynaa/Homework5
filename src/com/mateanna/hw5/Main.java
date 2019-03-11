package com.mateanna.hw5;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        try{
            System.out.println(calculator.calculate(2,'ö',7));
        }
        catch (NullPointerException e){
            System.out.println("Illegal Argument");
        }
    }
}
