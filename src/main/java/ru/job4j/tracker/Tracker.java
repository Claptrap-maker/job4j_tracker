package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        if (item != null) {
            item.setId(ids++);
            items[size++] = item;
            return item;
        }
        return null;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                result[index++] = items[i];
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int size = 0;
        if (key != null) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null && items[i].getName().equals(key)) {
                    result[size++] = items[i];
                }
            }
        }
        return Arrays.copyOf(result, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1 && item != null;
        if (rsl) {
            items[index] = item;
            item.setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size--] = null;
        }
        return rsl;
    }
}