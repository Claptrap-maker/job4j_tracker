package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftStringNumber = left.split(". ");
        String[] rightStringNumber = right.split(". ");
        int leftNumber = Integer.parseInt(leftStringNumber[0]);
        int rightNumber = Integer.parseInt(rightStringNumber[0]);
        return Integer.compare(leftNumber, rightNumber);
    }
}
