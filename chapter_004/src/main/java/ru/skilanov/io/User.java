package ru.skilanov.io;

/**
 * This is model class.
 */
public class User {
    /**
     * This is id.
     */
    private int id;
    /**
     * This is users name.
     */
    private String name;
    /**
     * This is users city.
     */
    private String city;

    /**
     * Tjis is default constructor.
     *
     * @param id   int
     * @param name String
     * @param city String
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Id getter.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter.
     *
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
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
     * City getter.
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * City setter.
     *
     * @param city String
     */
    public void setCity(String city) {
        this.city = city;
    }
}
