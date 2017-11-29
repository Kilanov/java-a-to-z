package ru.skilanov.io.testtask;

/**
 * Created by Semen on 13.11.2017.
 */

public class User {
    /**
     * @param name String
     */
    private String name;
    /**
     * @param passport int
     */
    private int passport;

    /**
     * This is default constructor.
     *
     * @param name     String
     * @param passport int
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * This is toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                + name
                + '\''
                + ", passport="
                + passport
                +
                '}';
    }

    /**
     * This is equals method.
     *
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (passport != user.passport) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;

    }

    /**
     * This is hashCode method.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + passport;
        return result;
    }

    /**
     * Getter.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return int
     */
    public int getPassport() {
        return passport;
    }

    /**
     * Setter.
     *
     * @param passport int
     */
    public void setPassport(int passport) {
        this.passport = passport;
    }
}
