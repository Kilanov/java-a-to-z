package ru.skilanov.service;

import ru.skilanov.models.*;
import ru.skilanov.service.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class StartUITest {

    @Test
    public void whenSetAddItemThenWeGetAddedItem() {
        String itemName = "name";
        String itemDesc = "description";
        String[] createdItem = new String[]{itemName, itemDesc};
        Input input = new StubInput(createdItem);
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);

        Item item = startUI.addItem();

        assertThat(item.getName(), is(itemName));
        assertThat(item.getDescription(), is(itemDesc));
    }

    @Test
    public void whenSetEditItemThenWeGetNewItem() {
        String itemId = "1";
        String itemName = "name";
        String itemDesc = "description";
        String[] createdItem = new String[]{itemId, itemName, itemDesc};
        Input input = new StubInput(createdItem);
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);

        Item item = startUI.editItem();

        assertThat(item.getId(), is(itemId));
        assertThat(item.getName(), is(itemName));
        assertThat(item.getDescription(), is(itemDesc));
    }

    @Test
    public void whenSetDeleteItemThenReturnDeletedItem() {
        String itemId = "1";
        String[] createdItem = new String[]{itemId};
        Input input = new StubInput(createdItem);
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);

        Item item = startUI.deleteItem();

        assertThat(item.getId(), is(itemId));
    }

    @Test
    public void whenSetAddCommentThenReturnAddedComment() {
        String itemId = "1";
        String[] createdItem = new String[]{itemId};
        Input input = new StubInput(createdItem);
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);

        Item item = startUI.addComment();

        assertThat(item.getId(), is(itemId));
    }

    @Test
    public void whenSetCreateCommentThenReturnCreatedComment() {
        String comment = "comment";
        String[] createdItem = new String[]{comment};
        Input input = new StubInput(createdItem);
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);

        String result = startUI.createComment();

        assertThat(result, is(comment));
    }

    @Test
    public void whenSetFindByIdThenReturnRightItem() {
        String itemName = "name";
        String itemDesc = "description";
        Item createdItem = new Item(itemName, itemDesc);
        Tracker tracker = new Tracker();
        tracker.add(createdItem);
        String id = tracker.findByName(itemName).getId();
        String[] itemId = new String[]{id};
        Input input = new StubInput(itemId);
        StartUI startUI = new StartUI(input, tracker);

        Item item = startUI.findById();

        assertThat(item.getId(), is(id));
    }

    @Test
    public void whenSetFindByNameThenReturnRightItem() {
        String itemName = "name";
        String itemDesc = "description";
        Item createdItem = new Item(itemName, itemDesc);
        Tracker tracker = new Tracker();
        tracker.add(createdItem);
        String name = tracker.findByName(itemName).getName();
        String[] itemNameList = new String[]{name};
        Input input = new StubInput(itemNameList);
        StartUI startUI = new StartUI(input, tracker);

        Item item = startUI.findByName();

        assertThat(item.getName(), is(name));
    }
}