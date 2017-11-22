package ru.skilanov.io.testTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is service class.
 */
public class Bank {
    /**
     * This is constant param.
     */
    private final Map<User, List<Account>> userList;

    /**
     * This is default constructor.
     *
     * @param userList Map
     */
    public Bank(Map<User, List<Account>> userList) {
        this.userList = userList;
    }

    /**
     * This is add method.
     *
     * @param user User
     */
    public void addUser(User user) {
        List<Account> list = new ArrayList<>();
        Account account = new Account(0, 0);
        list.add(account);
        userList.put(user, list);
    }

    /**
     * This is delete method.
     *
     * @param user User
     */
    public void deleteUser(User user) {
        userList.remove(user);
    }

    /**
     * This method adds account to user.
     *
     * @param user    User
     * @param account Account
     */
    public void addAccountToUser(User user, Account account) {
        List<Account> list = new ArrayList<>();
        list.add(account);
        userList.put(user, list);
    }

    /**
     * This method delete user.
     *
     * @param user    User
     * @param account Account
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> list = new ArrayList<>();
        list.remove(account);
        userList.put(user, list);
    }

    /**
     * This method shows accounts.
     *
     * @param user User
     * @return List
     */
    public List<Account> getUserAccounts(User user) {
        return userList.get(user);
    }

    /**
     * This method can transfer money from user to another  user.
     *
     * @param srcUser    User
     * @param srcAccount Account
     * @param dstUser    User
     * @param dstAccount Account
     * @param amount     double
     * @return boolean
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean transfer = false;
        List<Account> userSourceAccount = getUserAccounts(srcUser);
        List<Account> userDestAccount = getUserAccounts(dstUser);
        if (userList.containsKey(srcUser) && userList.containsKey(dstUser)) {
            for (Account source : userSourceAccount) {
                for (Account dest : userDestAccount) {
                    if (source.equals(srcAccount) && dest.equals(dstAccount)) {
                        if (source.getValue() > amount) {
                            source.setValue(source.getValue() - amount);
                            dest.setValue(dest.getValue() + amount);
                            transfer = true;
                            break;
                        }
                    }
                }
            }
        }
        return transfer;
    }
}
