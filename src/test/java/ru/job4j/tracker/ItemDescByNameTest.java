package ru.job4j.tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ItemDescByNameTest {

    @Test
    void sortDescByName() {
        Item item1 = new Item("First");
        Item item2 = new Item("Second");
        Item item3 = new Item("Third");
        Item item4 = new Item("Fourth");
        Item item5 = new Item("Fifth");
        Item item6 = new Item("Sixth");
        List<Item> items = Arrays.asList(item1, item2, item3, item4, item5, item6);
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(item3, item6, item2, item4, item1, item5);
        Assertions.assertIterableEquals(expected, items);
    }
}