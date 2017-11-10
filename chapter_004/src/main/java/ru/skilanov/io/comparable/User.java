package ru.skilanov.io.comparable;

/**
 * This is model class.
 */
public class User implements Comparable<User> {
    /**
     * This is id.
     */
    private int age;
    /**
     * This is name.
     */
    private String name;

    /**
     * This is default constructor.
     *
     * @param age  int
     * @param name String
     */
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /**
     * Age getter.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Age setter.
     *
     * @param age int
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Name getter.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is comparetor method.
     *
     * @param o User
     * @return user
     */
    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }
}
