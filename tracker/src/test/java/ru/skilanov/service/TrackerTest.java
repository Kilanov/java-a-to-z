package ru.skilanov;

import ru.skilanov.models.*;
import ru.skilanov.service.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenSetTaskInAddThenReturnAddedTask() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        Assert.assertEquals(item, tracker.add(item));
    }

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


    @Test
    public void whenSetNameInFindByNameTheReturnRightName() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        tracker.add(item);

        Item find = tracker.findByName("User");

        Assert.assertTrue(find == item);
    }

    @Test
    public void whenSetIdInFindByIdThenReturnRightId() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        tracker.add(item);
        String id = tracker.findByName("User").getId();

        Item find = tracker.findById(id);

        Assert.assertTrue(find == item);
    }

    @Test
    public void whenSetCommentInAddCommentThenReturnAddedComment() {
        Tracker tracker = new Tracker();
        Item item = new Item("User", "User's name is Semyon");
        tracker.add(item);
        tracker.addComment(item, "Comment");

        Assert.assertTrue(Arrays.asList(item.getComment().getCommentDescription()).contains("Comment"));
    }
}