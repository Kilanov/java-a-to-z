package ru.skilanov.io.generic;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test class for AbstractStore.
 */
public class AbstractStoreTest {
    /**
     * storeUser
     */
    AbstractStore storeUser = new UserStore(5);
    /**
     * StoreRole
     */
    AbstractStore storeRole = new RoleStore(5);

    /**
     * Test add method User.
     */
    @Test
    public void whenWeAddIdUserThenReturnRightResult() {
        User user1 = new User("88");
        storeUser.add(user1);
        User user2 = new User("99");
        storeUser.add(user2);
        Assert.assertThat(storeUser.findById("88").getId(), is("88"));
        Assert.assertThat(storeUser.findById("99").getId(), is("99"));
    }

    /**
     * Test add method Role.
     */
    @Test
    public void whenWeAddIdRoleThenReturnRightResult() {
        Role role1 = new Role("66");
        storeRole.add(role1);
        Role role2 = new Role("77");
        storeRole.add(role2);
        Assert.assertThat(storeRole.findById("66").getId(), is("66"));
        Assert.assertThat(storeRole.findById("77").getId(), is("77"));
    }

    /**
     * Test update method User.
     */
    @Test
    public void whenWeUpdateIdUserThenReturnResult() {
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        storeUser.add(user1);

        storeUser.replace("1", user2);

        assertThat(storeUser.findById("2").getId(), is("2"));

        storeUser.replace("2", user3);
        assertThat(storeUser.findById("3").getId(), is("3"));
    }

    /**
     * Test update method Role.
     */
    @Test
    public void whenWeUpdateIdRoleThenReturnResult() {
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("3");
        storeRole.add(role1);

        storeRole.replace("1", role2);

        assertThat(storeRole.findById("2").getId(), is("2"));

        storeRole.replace("2", role3);
        assertThat(storeRole.findById("3").getId(), is("3"));
    }

    /**
     * Test delete method User.
     */
    @Test
    public void whenWeDeleteIdUserThenReturnResult() {
        User user1 = new User("1");
        storeUser.add(user1);
        assertTrue(storeUser.delete("1"));
    }

    /**
     * Test delete method Role.
     */
    @Test
    public void whenWeDeleteIdStoreThenReturnResult() {
        Role role1 = new Role("1");
        storeRole.add(role1);
        assertTrue(storeRole.delete("1"));
    }
}
