package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, -10, 0, 122, 4567, -333, -12);
        List<Integer> positive = numbers.stream().filter((x) -> x > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
