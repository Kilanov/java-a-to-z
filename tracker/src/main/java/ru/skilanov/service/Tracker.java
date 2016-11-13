package ru.skilanov.service;

import ru.skilanov.models.*;
import java.util.Random;

/**
 * This class could make some operations with Item.
 */
public class Tracker {
    private static final Random RN = new Random();
    private Item[] items = new Item[10];
    private int position;

    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public void delete(Item item) {
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(item.getId())) {
                items[index] = null;
                break;
            }
        }
    }

    public void edit(Item item) {
        for (int index = 0; index < position; index++) {
            if (item != null && items[index].getId().equals(item.getId())) {
                items[index] = item;
                break;
            }
        }
    }

    public Item findByName(String name) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
            }
        }
        return result;
    }

    public void addComment(Item item, String comment) {
        if (findById(item.getId()) != null) {
            findById(item.getId()).getComment().add(comment);
        }
    }
}
