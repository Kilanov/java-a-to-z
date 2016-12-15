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
    public static final int ARRAY_SIZE = 7;
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
        this.actions[FIRST_MENU_POINT] = new AddItem("Add the Item");
        this.actions[SECOND_MENU_POINT] = new ShowItems("Show the Item");
        this.actions[THIRD_MENU_POINT] = new EditItem("Edit the item");
        this.actions[FOURTH_MENU_POINT] = new DeleteItem("Delete the item");
        this.actions[FIFTH_MENU_POINT] = new FindItemById("Find item by the id");
        this.actions[SIXTH_MENU_POINT] = new FindItemByName("Find id by the name");
        this.actions[SEVENTH_MENU_POINT] = new AddComment("Add the comment");
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
    private class AddItem extends BaseAction {

        /**
         * This is constant param.
         */
        public static final int NULL = 0;

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        AddItem(String name) {
            super(name);
        }

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
    }

    /**
     * This class shows all Items.
     */
    public class ShowItems extends BaseAction {
        /**
         * This is constant param.
         */
        public static final int ONE = 1;

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public ShowItems(String name) {
            super(name);
        }

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
    }

    /**
     * This class edit Items.
     */
    public class EditItem extends BaseAction {
        /**
         * This is constant param.
         */
        public static final int TWO = 2;

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public EditItem(String name) {
            super(name);
        }

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
    }

    /**
     * This class delete Items.
     */
    public class DeleteItem extends BaseAction {
        /**
         * This is constant param.
         */
        public static final int THREE = 3;

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public DeleteItem(String name) {
            super(name);
        }

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
    }

    /**
     * This class finds Items by id.
     */
    public class FindItemById extends BaseAction {
        /**
         * This is constant param.
         */
        public static final int FOUR = 4;

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public FindItemById(String name) {
            super(name);
        }

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
    }

    /**
     * This class finds Items by name.
     */
    public class FindItemByName extends BaseAction {
        /**
         * This is constant param.
         */
        public static final int FIVE = 5;

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public FindItemByName(String name) {
            super(name);
        }

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
    }

    /**
     * This class adds comments.
     */
    public class AddComment extends BaseAction {
        /**
         * This is constant param.
         */
        public static final int SIX = 6;

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public AddComment(String name) {
            super(name);
        }

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
    }
}
