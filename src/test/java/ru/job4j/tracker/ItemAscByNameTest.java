package ru.job4j.tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ItemAscByNameTest {

    @Test
    void sortAscByName() {
        Item item1 = new Item("First");
        Item item2 = new Item("Second");
        Item item3 = new Item("Third");
        Item item4 = new Item("Fourth");
        Item item5 = new Item("Fifth");
        Item item6 = new Item("Sixth");
        List<Item> items = Arrays.asList(item1, item2, item3, item4, item5, item6);
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(item5, item1, item4, item2, item6, item3);
        Assertions.assertIterableEquals(expected, items);
    }
}