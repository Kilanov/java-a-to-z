package ru.skilanov.service;

import ru.skilanov.service.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class StubInputTest {

    @Test
    public void whenSetAddItemThenReturnItem() {
        String showAllItems = "1";
        String addItem = "2";
        String editItem = "3";
        String deleteItem = "4";
        String addComment = "5";
        String findById = "6";
        String findByName = "7";

        String[] menuPoints = new String[]{showAllItems, addItem, editItem, deleteItem, addComment, findById, findByName};
        StubInput stubInput = new StubInput(menuPoints);

        String firstMenuPoint = stubInput.ask("Show All Items");
        String secondMenuPoint = stubInput.ask("Add Item");
        String thirdMenuPoint = stubInput.ask("Edit Item");
        String fourthMenuPoint = stubInput.ask("Delete Item");
        String fifthMenuPoint = stubInput.ask("Add Comment");
        String sixthMenuPoint = stubInput.ask("Find By Id");
        String seventhMenuPoint = stubInput.ask("Find By Name");

        assertThat(firstMenuPoint, is(showAllItems));
        assertThat(thirdMenuPoint, is(editItem));
        assertThat(secondMenuPoint, is(addItem));
        assertThat(fourthMenuPoint, is(deleteItem));
        assertThat(fifthMenuPoint, is(addComment));
        assertThat(sixthMenuPoint, is(findById));
        assertThat(seventhMenuPoint, is(findByName));
    }
}