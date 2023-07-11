package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Количество пассажиров в автобусе " + number);
    }

    @Override
    public double refuel(double liters) {
        return liters * 55.9;
    }
}
