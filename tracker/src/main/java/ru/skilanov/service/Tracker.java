package ru.skilanov.service;

import ru.skilanov.models.Item;
import java.util.Random;

/**
 * This class could make some operations with Item.
 */
public class Tracker {
    /**
     * Constant param of the array size.
     */
    public static final int ARRAY_SIZE = 10;
    /**
     * Constant param.
     */
    public static final int BOUND = 100;
    /**
     * this param gives us random number.
     */
    private static final Random RN = new Random();
    /**
     * Items array.
     */
    private Item[] items = new Item[ARRAY_SIZE];
    /**
     * position int.
     */
    private int position;

    /**
     * This method add items to the array.
     *
     * @param item item
     * @return item
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * This method find item by id.
     *
     * @param id String
     * @return result
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    /**
     * Id generator.
     *
     * @return id
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(BOUND));
    }

    /**
     * This method gets list of all items.
     *
     * @return result
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * This method delete items.
     *
     * @param item Item
     */
    public void delete(Item item) {
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(item.getId())) {
                items[index] = null;
                break;
            }
        }
    }

    /**
     * This method edit items.
     *
     * @param item Item
     */
    public void edit(Item item) {
        for (int index = 0; index < position; index++) {
            if (item != null && items[index].getId().equals(item.getId())) {
                items[index] = item;
                break;
            }
        }
    }

    /**
     * This metho funds item by name.
     *
     * @param name String
     * @return result
     */
    public Item findByName(String name) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
            }
        }
        return result;
    }

    /**
     * This method add comments.
     *
     * @param item    Item
     * @param comment String
     */
    public void addComment(Item item, String comment) {
        if (findById(item.getId()) != null) {
            findById(item.getId()).getComment().add(comment);
        }
    }
}