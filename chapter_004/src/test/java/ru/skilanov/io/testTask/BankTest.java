package ru.skilanov.io.testtask;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;

/**
 * This is test class for Bank.
 */

public class BankTest {

    /**
     * This is test method for AddUser.
     */
    @Test
    public void whenAddUserThenWeGetThem() {
        Map<User, List<Account>> userList = new HashMap<>();
        Bank bank = new Bank(userList);
        User user = new User("name", 1234);
        bank.addUser(user);

        Assert.assertTrue(userList.containsKey(user));
    }

    /**
     * This is test method for DeleteUser.
     */
    @Test
    public void whenDeleteUserThenUserDoesNotExist() {
        Map<User, List<Account>> userList = new HashMap<>();
        Bank bank = new Bank(userList);
        User user = new User("name", 1234);
        bank.addUser(user);

        bank.deleteUser(user);

        Assert.assertFalse(userList.containsKey(user));
    }

    /**
     * This is test method for Add Account.
     */
    @Test
    public void whenAddAccToUserTheWeHaveAnAccount() {
        Map<User, List<Account>> userList = new HashMap<>();
        Bank bank = new Bank(userList);
        User user = new User("name", 1234);
        Account account = new Account(11, 1111);
        List<Account> list = new ArrayList<>();
        list.add(account);
        bank.addAccountToUser(user, account);

        Assert.assertTrue(userList.containsValue(list));
    }

    /**
     * This is test method for delete account.
     */
    @Test
    public void whenDeleteAccFromUserThenUserDoesNotHaveAnAcc() {
        Map<User, List<Account>> userList = new HashMap<>();
        Bank bank = new Bank(userList);
        User user = new User("name", 1234);
        Account account = new Account(11, 1111);
        List<Account> list = new ArrayList<>();
        list.add(account);
        bank.addAccountToUser(user, account);

        bank.deleteAccountFromUser(user, account);

        Assert.assertFalse(userList.containsValue(list));
    }

    /**
     * This is test method for getUserList.
     */
    @Test
    public void whenGetUserAccThenReturnAcc() {
        Map<User, List<Account>> userList = new HashMap<>();
        Bank bank = new Bank(userList);
        User user = new User("name", 1234);
        Account accountRub = new Account(11, 1111);
        bank.addAccountToUser(user, accountRub);
        List<Account> list = new ArrayList<>();
        list.add(accountRub);
        List<Account> result = bank.getUserAccounts(user);
        Assert.assertTrue(result.equals(list));
    }

    /**
     * This is test method for MoneyTransfer.
     */
    @Test
    public void whenTransferMoneyThenReturnResult() {
        Map<User, List<Account>> userList = new HashMap<>();
        Bank bank = new Bank(userList);
        User alex = new User("alex", 1234);
        User anton = new User("anton", 5678);
        Account accountAlexander = new Account(11, 111);
        Account accountAnton = new Account(0, 222);
        bank.addUser(alex);
        bank.addUser(anton);

        bank.addAccountToUser(alex, accountAlexander);
        bank.addAccountToUser(anton, accountAnton);

        bank.transferMoney(alex, accountAlexander, anton, accountAnton, 10);

        Assert.assertThat(accountAlexander.getValue(), is(1.0));
    }
}
