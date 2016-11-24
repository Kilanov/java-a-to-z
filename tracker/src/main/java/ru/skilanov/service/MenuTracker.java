package ru.skilanov.service;

import ru.skilanov.models.Item;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[8];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
        this.actions[6] = new AddComment();
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    private class AddItem implements UserAction {


        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String itemName = input.ask("Enter item's name");
            String itemDesc = input.ask("Enter item's description");
            tracker.add(new Item(itemName, itemDesc));
        }

        public String info() {
            return String.format("%s %s", this.key(), "Add the new Item");
        }
    }

    public class ShowItems implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null) {
                    System.out.println(String.format("%s %s %s %s", this.key(), item.getId(), item.getName(), item.getDescription()));
                }
            }
        }

        public String info() {
            return String.format("%s  %s", this.key(), "Show all items");
        }
    }

    public class EditItem implements UserAction {

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter id for the editing");
            String itemName = input.ask("Please enter new name");
            String itemDesc = input.ask("Please enter new description");
            Item item = new Item(itemName, itemDesc);
            item.setId(id);
            tracker.edit(item);
        }

        public String info() {
            return String.format("%s %s", this.key(), "Edit item");
        }
    }

    public class DeleteItem implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter id for the deleting");
            Item item = new Item();
            item.setId(id);
            tracker.delete(item);
        }

        public String info() {
            return String.format("%s %s", this.key(), "Delete item");
        }
    }

    public class FindItemById implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String findById = input.ask("Please, enter id: ");
            Item item = tracker.findById(findById);
            if (item != null) {
                System.out.println(String.format("%s %s %s", this.key(), item.getName(), item.getDescription()));
            }
        }

        public String info() {
            return String.format("%s %s", this.key(), "Find item by id");
        }
    }

    public class FindItemByName implements UserAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String findByName = input.ask("Please, enter name: ");
            Item item = tracker.findByName(findByName);
            if (item != null) {
                System.out.println(String.format("%s %s %s", this.key(), item.getName(), item.getDescription()));
            }
        }

        public String info() {
            return String.format("%s %s", this.key(), "Find item by name");
        }
    }

    public class AddComment implements UserAction {

        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter id: ");
            String comment = input.ask("Please enter comment: ");
            Item item = new Item();
            tracker.addComment(item, comment);

        }

        public String info() {
            return String.format("%s %s", this.key(), "Add comment");
        }
    }
}