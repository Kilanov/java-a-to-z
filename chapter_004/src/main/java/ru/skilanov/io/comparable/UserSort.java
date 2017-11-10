package ru.skilanov.io.comparable;

import java.util.Comparator;
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

    /**
     * This method sort users by names length.
     *
     * @param list User
     * @return List
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    /**
     * This nethod sorts users by all fields.
     *
     * @param list Users
     * @return List
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int nameLengthResult = Integer.compare(o1.getName().length(), o2.getName().length());
                return nameLengthResult != 0 ? nameLengthResult : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
