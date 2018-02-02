package ru.skilanov.io.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Test class for Users.
 */
public class UsersTest {

    /**
     * Equals test.
     */
    @Test
    public void whenWeUseEqualsThenReturnRightResult() {
        Calendar birthday = new GregorianCalendar();
        birthday.set(1990, 05, 04);

        Users firstUser = new Users("sam", 27, birthday);
        Users secondUser = new Users("sam", 27, birthday);
        Users thirdUser = new Users("sam", 27, birthday);
        Users fourthUser = new Users("den", 28, birthday);

        Map<Users, Object> map = new HashMap<>();
        map.put(firstUser, "First");
        map.put(secondUser, "Second");
        map.put(thirdUser, "Third");
        map.put(fourthUser, "Fourth");

        Assert.assertTrue(firstUser.equals(secondUser));
        Assert.assertTrue(secondUser.equals(firstUser));
        Assert.assertTrue(secondUser.equals(thirdUser));
        Assert.assertTrue(firstUser.equals(thirdUser));
        Assert.assertFalse(thirdUser.equals(fourthUser));
    }

    /**
     * HashCode test.
     */
    @Test
    public void whenWeUseHashCodeThenReturnRightResult() {
        Calendar birthday = new GregorianCalendar();
        birthday.set(1990, 05, 04);

        Users firstUser = new Users("sam", 27, birthday);
        Users secondUser = new Users("sam", 27, birthday);
        Users thirdUser = new Users("den", 28, birthday);

        Map<Users, Object> map = new HashMap<>();
        map.put(firstUser, "First");
        map.put(secondUser, "Second");
        map.put(thirdUser, "Third");

        Assert.assertTrue(firstUser.hashCode() == secondUser.hashCode());
        Assert.assertFalse(secondUser.hashCode() == thirdUser.hashCode());
    }
}
