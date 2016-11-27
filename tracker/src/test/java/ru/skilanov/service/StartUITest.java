package ru.skilanov.service;

import ru.skilanov.models.Item;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import org.junit.Test;

/**
 * This class tests StartUI class.
 */
public class StartUITest {

    /**
     * Test of add method.
     */
    @Test
    public void whenSetAddItemThenReturnAddedItem() {
        Tracker tracker = new Tracker();
        String[] points = new String[]{"0", "a", "b", "y"};
        Input input = new StubInput(points);
        StartUI startUI = new StartUI(input, tracker);

        startUI.init();
        Item item = tracker.findByName("a");

        assertThat(item.getName(), is("a"));
        assertThat(item.getDescription(), is("b"));
    }

    /**
     * Test of show method.
     */
    @Test
    public void whenSetShowAllItemsThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[]{new Item("a", "b")};
        for (Item item : items) {
            tracker.add(item);
        }
        String[] points = new String[]{"1", "y"};
        Input input = new StubInput(points);
        StartUI startUI = new StartUI(input, tracker);

        startUI.init();
        Item[] result = tracker.getAll();

        assertThat(items, is(result));
    }

    /**
     * Test of edit method.
     */
    @Test
    public void whenSetEditItemThenReturnNewItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("a", "b"));
        String id = tracker.findByName("a").getId();
        String[] points = new String[]{"2", id, "b", "a", "y"};
        Input input = new StubInput(points);
        StartUI startUI = new StartUI(input, tracker);

        startUI.init();
        Item item = tracker.findByName("b");

        assertThat(item.getName(), is("b"));
        assertThat(item.getDescription(), is("a"));
    }

    /**
     * Test of delete method.
     */
    @Test
    public void whenSetDeleteItemThenReturnDeletedItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("a", "b"));
        String id = tracker.findByName("a").getId();
        String[] points = new String[]{"3", id, "y"};
        Input input = new StubInput(points);
        StartUI startUI = new StartUI(input, tracker);

        startUI.init();
        Item item = tracker.findByName("a");

        assertThat(null, is(item));
    }

    /**
     * Test of find by id method.
     */
    @Test
    public void whenSetFindByIdThenReturnRightItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("a", "b"));
        String id = tracker.findByName("a").getId();
        String[] points = new String[]{"4", id, "y"};
        Input input = new StubInput(points);
        StartUI startUI = new StartUI(input, tracker);

        startUI.init();
        Item item = tracker.findById(id);

        assertThat(item.getId(), is(id));
    }

    /**
     * Test of find by name method.
     */
    @Test
    public void whenSetFindByNameThenReturnRightItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("a", "b"));
        String[] points = new String[]{"5", "a", "y"};
        Input input = new StubInput(points);
        StartUI startUI = new StartUI(input, tracker);

        startUI.init();
        Item item = tracker.findByName("a");

        assertThat(item.getName(), is("a"));
    }

    /**
     * Test of add comment method.
     */
    @Test
    public void whenSetAddCommentThenReturnAddedComment() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("a", "b"));
        String id = tracker.findByName("a").getId();
        String[] points = new String[]{"6", id, "comment", "y"};
        Input input = new StubInput(points);
        StartUI startUI = new StartUI(input, tracker);

        startUI.init();
        Item item = tracker.findById(id);

        assertTrue(Arrays.asList(item.getComment().getCommentDescription()).contains("comment"));
    }
}
