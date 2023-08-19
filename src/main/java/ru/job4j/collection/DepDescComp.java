package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (Objects.equals(left.toLowerCase().split("/")[0],
                right.toLowerCase().split("/")[0])) {
            return left.compareTo(right);
        } else {
            return right.compareTo(left);
        }
    }
}
