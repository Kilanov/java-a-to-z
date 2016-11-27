package ru.skilanov;

import ru.skilanov.models.Item;
import ru.skilanov.service.Tracker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests Tracker class.
 */
public class TrackerTest {
    /**
     * Test of add method.
     */
    @Test
    public void whenSetTaskInAddThenReturnAddedTask() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        Assert.assertEquals(item, tracker.add(item));
    }

    /**
     * Test of the get all method.
     */
    @Test
    public void whenSetTaskInGetAllThenReturnTheSame() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[]{new Item("User", "User's name is Semyon")};
        for (Item item : items) {
            tracker.add(item);
        }
        Item[] result = tracker.getAll();
        assertThat(result, is(items));
    }

    /**
     * Test of the delete method.
     */
    @Test
    public void whenSetTaskInDeleteThenReturnDeletedTask() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        tracker.add(item);
        Item[] result = tracker.getAll();
        tracker.delete(item);
        Item[] resultAfterDeleting = tracker.getAll();

        Assert.assertNotEquals(result, resultAfterDeleting);
    }

    /**
     * Test of the edit method.
     */
    @Test
    public void whenSetTaskInEditTheReturnEditedTask() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        tracker.add(item);
        Item[] resultBefore = tracker.getAll();
        String name = tracker.findByName("User").getId();
        Item secondItem = new Item("User2", "User's name is Sam");
        secondItem.setId(name);
        tracker.edit(secondItem);
        Item[] resultAfter = tracker.getAll();

        Assert.assertNotEquals(resultBefore, resultAfter);
    }

    /**
     * Test of the find by name method.
     */
    @Test
    public void whenSetNameInFindByNameTheReturnRightName() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        tracker.add(item);

        Item find = tracker.findByName("User");

        assertThat(find, is(item));
    }

    /**
     * Test of the find by id method.
     */
    @Test
    public void whenSetIdInFindByIdThenReturnRightId() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        tracker.add(item);
        String id = tracker.findByName("User").getId();

        Item find = tracker.findById(id);

        assertThat(find, is(item));
    }

    /**
     * Test of the add comment method.
     */
    @Test
    public void whenSetCommentInAddCommentThenReturnAddedComment() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        tracker.add(item);
        tracker.addComment(item, "Comment");

        Assert.assertTrue(Arrays.asList(item.getComment().getCommentDescription()).contains("Comment"));
    }
}