package ru.skilanov.service;

import ru.skilanov.models.Item;
import java.util.Scanner;

public class StartUI {
    private Input input;
    private Tracker tracker;
    private Scanner scanner = new Scanner(System.in);

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }

    public void init() {
        tracker.add(new Item("name first ", "first desc"));
        tracker.add(new Item("name second ", "second desc"));
        tracker.add(new Item("name third ", "third desc"));
        menu();
        boolean exit = false;
        int menuItem = Integer.parseInt(input.ask("Please, enter the command: "));
        while (!exit) {
            if (menuItem == 1) {
                showAllItems();
		break;
            } else if (menuItem == 2) {
                Item item = addItem();
                tracker.add(item);
		break;
            } else if (menuItem == 3) {
                Item item = editItem();
                tracker.edit(item);
                break;
            } else if (menuItem == 4) {
                Item item = deleteItem();
                tracker.delete(item);
                break;
            } else if (menuItem == 5) {
                Item item = addComment();
                String comment = createComment();
                tracker.addComment(item, comment);
            } else if (menuItem == 6) {
                Item item = findById();
            } else if (menuItem == 7) {
                Item item = findByName();
            }
        }
    }


    public void menu() {
        System.out.println("Please choose any menu item:" + "\n" +
                "1. Please enter 1 to show all items" + "\n" +
                "2. Please enter 2 to add item" + "\n" +
                "3. Please enter 3 to edit an item" + "\n" +
                "4. Please enter 4 to delete an item" + "\n" +
                "5. Please enter 5 to add a comment" + "\n" +
                "6. Please enter 6 to find item by id" + "\n" +
                "7. Please enter 7 to find item by name");
    }

    public void showAllItems() {
        for (Item item : tracker.getAll()) {
            System.out.println(item.getId() + item.getName() + item.getDescription());
        }
    }

    public Item addItem() {
        String itemName = input.ask("Enter item's name");
        String itemDesc = input.ask("Enter item's description");
        Item item = new Item(itemName, itemDesc);
        return item;
    }

    public Item editItem() {
        String id = input.ask("Please enter id for the editing");
        String itemName = input.ask("Please enter new name");
        String itemDesc = input.ask("Please enter new description");
        Item item = new Item(itemName, itemDesc);
        item.setId(id);
        return item;
    }

    public Item deleteItem() {
        String id = input.ask("Please enter id for the deleting");
        Item item = new Item();
        item.setId(id);
        return item;
    }

    public Item addComment() {
        String id = input.ask("Please enter id: ");
        Item item = new Item();
        item.setId(id);
        return item;
    }

    public String createComment() {
        String comment = input.ask("Please, enter a comment: ");
        return comment;
    }

    public Item findById() {
        String findById = input.ask("Please, enter id: ");
        Item item = tracker.findById(findById);
        return item;
    }

    public Item findByName() {
        String findByName = input.ask("Please, enter name: ");
        Item item = tracker.findByName(findByName);
        return item;
    }
}