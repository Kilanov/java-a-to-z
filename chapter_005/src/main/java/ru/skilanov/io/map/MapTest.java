package ru.skilanov.io.map;

import org.junit.Test;

import java.util.*;
import java.util.HashMap;

public class MapTest {
    @Test
    public void whenWePutKeyAndValueIntoTheMapThenReturnResults() {
        Calendar birthday = new GregorianCalendar();
        birthday.set(1990, 05, 04);

        User firstUser = new User("sam", 27, birthday);
        User secondUser = new User("sam", 27, birthday);

        Map<User, Object> map = new HashMap<>();
        map.put(firstUser, "First");
        map.put(secondUser, "Second");
        System.out.println(map);
    }

    /**
     * Model class.
     */
    public final class User {
        /**
         * Name variable
         */
        String name;
        /**
         * Children variable
         */
        int children;
        /**
         * Birthday variable
         */
        Calendar birthday;

        /**
         * Default constructor
         *
         * @param name     String
         * @param children int
         * @param birthday Calendar
         */
        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }

        /**
         * Equals method.
         *
         * @param o Object
         * @return boolean
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return children == user.children &&
                    Objects.equals(name, user.name) &&
                    Objects.equals(birthday, user.birthday);
        }

        /**
         * hashCode method.
         *
         * @return int
         */
        @Override
        public int hashCode() {
            return Objects.hash(name, children, birthday);
        }
    }
}
