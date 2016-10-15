package ru.skilanov.arrayduplicate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DuplicateTest {
    @Test
    public void whenSetArrayInDuplicateDeletingThenReturnArrayWithoutDuplicates() {
        Duplicate deleting = new Duplicate();
        String[] result = deleting.duplicateDeleting(new String[]{"ab", "ds", "ab"});
        String[] expected = new String[]{"ab", "ds"};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSetTheSameValueInDuplicateDeletingThenReturnOneValue(){
        Duplicate deleting = new Duplicate();
        String[] result = deleting.duplicateDeleting(new String[]{"ab", "ab"});
        String[] expected = new String[]{"ab"};
        assertThat(result, is(expected));
    }

    @Test
    public void whnSetOneValueInDuplicateDeletingThenReturnOneValue(){
        Duplicate deleting = new Duplicate();
        String[] result = deleting.duplicateDeleting(new String[]{"ab"});
        String[] expected = new String[]{"ab"};
        assertThat(result, is(expected));
    }

    @Test
    public void whnSetNullValueInDuplicateDeletingThenReturnNullValue(){
        Duplicate deleting = new Duplicate();
        String[] result = deleting.duplicateDeleting(new String[]{""});
        String[] expected = new String[]{""};
        assertThat(result, is(expected));
    }
}