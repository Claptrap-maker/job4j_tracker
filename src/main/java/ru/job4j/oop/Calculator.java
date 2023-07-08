package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + multiply(number) + minus(number) + divide(number);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(Calculator.sum(10));
        System.out.println(Calculator.minus(20));
        System.out.println(calc.multiply(3));
        System.out.println(calc.divide(17));
        System.out.println(calc.sumAllOperation(18));
    }
}
