package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int counterGreaterLeft = 0;
        int counterGreaterRight = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            if (Character.compare(leftChar, rightChar) > 0) {
                counterGreaterLeft++;
            } else if (Character.compare(leftChar, rightChar) < 0) {
                counterGreaterRight++;
            }
        }
        if (counterGreaterRight == 0 && counterGreaterLeft == 0) {
            if (left.length() > right.length()) {
                return 1;
            }
            if (right.length() > left.length()) {
                return -1;
            }
        }
        return Integer.compare(counterGreaterLeft, counterGreaterRight);
    }
}