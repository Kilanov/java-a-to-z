package ru.skilanov.io.comparable;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class sorts users.
 */
public class UserSort {

    /**
     * This is sort method.
     *
     * @param list List
     * @return TreeSet
     */
    public Set<User> sort(List<User> list) {
        Set<User> user = new TreeSet<>();
        user.addAll(list);
        return user;
    }
}
