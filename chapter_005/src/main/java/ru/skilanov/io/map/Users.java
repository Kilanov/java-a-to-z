package ru.skilanov.io.map;

import java.util.Calendar;

/**
 * Model class Users.
 */
public class Users {
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
     * Default constructor.
     *
     * @param name     String
     * @param children int
     * @param birthday Calendar
     */
    public Users(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Equals method that compare values.
     *
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Users)) {
            return false;
        }

        Users user = (Users) o;

        return user.name == name && user.children == children && user.birthday == birthday;
    }

    /**
     * HashCode method that return hashcode of the value.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + children;
        result = 31 * result + birthday.hashCode();
        return result;
    }
}
