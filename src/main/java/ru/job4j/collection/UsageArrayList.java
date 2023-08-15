package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<>();
        values.add("Petr");
        values.add("Ivan");
        values.add("Stepan");
        for (String name : values) {
            System.out.println(name);
        }
    }
}
