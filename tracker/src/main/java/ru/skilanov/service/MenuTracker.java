package ru.skilanov.service;

import ru.skilanov.models.Item;

/**
 * This class gives users choice of a menu points for creating operations with Items.
 */
public class MenuTracker {
    /**
     * This is constant param.
     */
    public static final int FIRST_MENU_POINT = 0;
    /**
     * This is constant param.
     */
    public static final int SECOND_MENU_POINT = 1;
    /**
     * This is constant param.
     */
    public static final int THIRD_MENU_POINT = 2;
    /**
     * This is constant param.
     */
    public static final int FOURTH_MENU_POINT = 3;
    /**
     * This is constant param.
     */
    public static final int FIFTH_MENU_POINT = 4;
    /**
     * This is constant param.
     */
    public static final int SIXTH_MENU_POINT = 5;
    /**
     * This is constant param.
     */
    public static final int SEVENTH_MENU_POINT = 6;
    /**
     * This is constant param.
     */
    public static final int ARRAY_SIZE = 8;
    /**
     * Input param.
     */
    private Input input;
    /**
     * Tracker param.
     */
    private Tracker tracker;
    /**
     * UserAction array for all menu points.
     */
    private UserAction[] actions = new UserAction[ARRAY_SIZE];

    /**
     * This constructor gets class params.
     *
     * @param input   Input
     * @param tracker Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * This method fill menu points.
     */
    public void fillActions() {
        this.actions[FIRST_MENU_POINT] = new AddItem();
        this.actions[SECOND_MENU_POINT] = new ShowItems();
        this.actions[THIRD_MENU_POINT] = new EditItem();
        this.actions[FOURTH_MENU_POINT] = new DeleteItem();
        this.actions[FIFTH_MENU_POINT] = new FindItemById();
        this.actions[SIXTH_MENU_POINT] = new FindItemByName();
        this.actions[SEVENTH_MENU_POINT] = new AddComment();
    }

    /**
     * This class shows menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * This method selects an action.
     *
     * @param key int
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * This class add an Item.
     */
    private class AddItem implements UserAction {

        /**
         * This is constant param.
         */
        public static final int NULL = 0;

        /**
         * This method makes position of menu point.
         *
         * @return key int
         */
        public int key() {
            return NULL;
        }

        /**
         * This method execute adding of the Item.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String itemName = input.ask("Enter item's name");
            String itemDesc = input.ask("Enter item's description");
            tracker.add(new Item(itemName, itemDesc));
        }

        /**
         * This method shows some info for user.
         *
         * @return users text
         */
        public String info() {
            return String.format("%s %s", this.key(), "Add the new Item");
        }
    }

    /**
     * This class shows all Items.
     */
    public class ShowItems implements UserAction {
        /**
         * This is constant param.
         */
        public static final int ONE = 1;

        /**
         * This method makes position of menu point.
         *
         * @return key int
         */
        public int key() {
            return ONE;
        }

        /**
         * This method execute showing of the Items.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null) {
                    System.out.println(String.format("%s %s %s %s", this.key(), item.getId(), item.getName(), item.getDescription()));
                }
            }
        }

        /**
         * This method shows some info for user.
         *
         * @return users text
         */
        public String info() {
            return String.format("%s  %s", this.key(), "Show all items");
        }
    }

    /**
     * This class edit Items.
     */
    public class EditItem implements UserAction {
        /**
         * This is constant param.
         */
        public static final int TWO = 2;

        /**
         * This method makes position of menu point.
         *
         * @return key int
         */
        public int key() {
            return TWO;
        }

        /**
         * This method execute editing of the Item.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter id for the editing");
            String itemName = input.ask("Please enter new name");
            String itemDesc = input.ask("Please enter new description");
            Item item = new Item(itemName, itemDesc);
            item.setId(id);
            tracker.edit(item);
        }

        /**
         * This method shows some info for user.
         *
         * @return users text
         */
        public String info() {
            return String.format("%s %s", this.key(), "Edit item");
        }
    }

    /**
     * This class delete Items.
     */
    public class DeleteItem implements UserAction {
        /**
         * This is constant param.
         */
        public static final int THREE = 3;

        /**
         * This method makes position of menu point.
         *
         * @return key int
         */
        public int key() {
            return THREE;
        }

        /**
         * This method execute deleting of the Item.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter id for the deleting");
            Item item = new Item();
            item.setId(id);
            tracker.delete(item);
        }

        /**
         * This method shows some info for user.
         *
         * @return users text
         */
        public String info() {
            return String.format("%s %s", this.key(), "Delete item");
        }
    }

    /**
     * This class finds Items by id.
     */
    public class FindItemById implements UserAction {
        /**
         * This is constant param.
         */
        public static final int FOUR = 4;

        /**
         * This method makes position of menu point.
         *
         * @return key int
         */
        public int key() {
            return FOUR;
        }

        /**
         * This method execute finding by id.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String findById = input.ask("Please, enter id: ");
            Item item = tracker.findById(findById);
            if (item != null) {
                System.out.println(String.format("%s %s %s", this.key(), item.getName(), item.getDescription()));
            }
        }

        /**
         * This method shows some info for user.
         *
         * @return users text
         */
        public String info() {
            return String.format("%s %s", this.key(), "Find item by id");
        }
    }

    /**
     * This class finds Items by name.
     */
    public class FindItemByName implements UserAction {
        /**
         * This is constant param.
         */
        public static final int FIVE = 5;

        /**
         * This method makes position of menu point.
         *
         * @return key int
         */
        public int key() {
            return FIVE;
        }

        /**
         * This method execute finding by name.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String findByName = input.ask("Please, enter name: ");
            Item item = tracker.findByName(findByName);
            if (item != null) {
                System.out.println(String.format("%s %s %s", this.key(), item.getName(), item.getDescription()));
            }
        }

        /**
         * This method shows some info for user.
         *
         * @return users text
         */
        public String info() {
            return String.format("%s %s", this.key(), "Find item by name");
        }
    }

    /**
     * This class adds comments.
     */
    public class AddComment implements UserAction {
        /**
         * This is constant param.
         */
        public static final int SIX = 6;

        /**
         * This method makes position of menu point.
         *
         * @return key int
         */
        public int key() {
            return SIX;
        }

        /**
         * This method execute adding of the comments.
         *
         * @param input   Input
         * @param tracker Tracker
         */
	public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter id: ");
            String comment = input.ask("Please enter comment: ");
            Item item = new Item();
            item.setId(id);
            tracker.addComment(item, comment);

        }

        /**
         * This method shows some info for user.
         *
         * @return users text
         */
        public String info() {
            return String.format("%s %s", this.key(), "Add comment");
        }
    }
}