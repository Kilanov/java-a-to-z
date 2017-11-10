package ru.skilanov.io;

import java.util.HashMap;
import java.util.List;

/**
 * This is class that converts List to HashMap.
 */
public class UserConvert {
    /**
     * This method converts List to HashMap.
     *
     * @param list Lsit<User>
     * @return HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User i : list) {
            map.put(i.getId(), i);
        }
        return map;
    }
}
