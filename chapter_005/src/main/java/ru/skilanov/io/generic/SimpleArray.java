package ru.skilanov.io.generic;

/**
 * This is simple array class with generic.
 *
 * @param <T>
 */
public class SimpleArray<T> {
    /**
     * This is array
     */
    Object[] objects;
    /**
     * This is index
     */
    int index = 0;

    /**
     * This is constructor.
     *
     * @param size int
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * This is add method.
     *
     * @param value T
     */
    public void add(T value) {
        objects[index++] = value;
    }

    /**
     * This is update method.
     *
     * @param index int
     * @param value T
     */
    public void update(int index, T value) {
        for (int i = 0; i < objects.length; i++) {
            if (index == i) {
                objects[index] = value;
            }
        }
    }

    /**
     * This is delete method.
     *
     * @param index int
     */
    public void delete(int index) {
        for (int i = 0; i < objects.length; i++) {
            if (index == i) {
                objects[index] = 0;
            }
        }
    }

    /**
     * This is get method.
     *
     * @param position int
     * @return T
     */
    public T get(int position) {
        return (T) objects[position];
    }
}