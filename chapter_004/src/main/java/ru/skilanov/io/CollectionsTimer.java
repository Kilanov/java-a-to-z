package ru.skilanov.io;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;


/**
 * This test task that shows working time of collections.
 */
public class CollectionsTimer {
    /**
     * This is main method.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        CollectionsTimer timer = new CollectionsTimer();
        List<String> linkedList = new LinkedList<String>();
        List<String> arrayList = new ArrayList<String>();
        Set<String> treeSet = new TreeSet<String>();

        System.out.println("LinkedList add time is: " + String.format("%s  %s", timer.add(linkedList, 20000), "ms"));
        System.out.println("ArrayList add time is: " + String.format("%s  %s", timer.add(arrayList, 20000), "ms"));
        System.out.println("TreeSet add time is: " + String.format("%s  %s", timer.add(treeSet, 20000), "ms"));

        System.out.println("LinkedList remove time is: " + String.format("%s  %s", timer.delete(linkedList, 19000), "ms"));
        System.out.println("ArrayList remove time is: " + String.format("%s  %s", timer.delete(arrayList, 19000), "ms"));
        System.out.println("TreeSet remove time is: " + String.format("%s  %s", timer.delete(treeSet, 19000), "ms"));
    }

    /**
     * This method adds strings to our collections.
     *
     * @param collection Collection
     * @param amount     int
     * @return long
     */
    public long add(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i <= amount; i++) {
            collection.add("aa");
        }
        long finish = System.currentTimeMillis();
        long result = finish - start;

        return result;
    }

    /**
     * This method removes strings from our collections.
     *
     * @param collection Collection
     * @param amount     int
     * @return long
     */
    public long delete(Collection<String> collection, int amount) {
        for (int i = 0; i <= 20000; i++) {
            collection.add("aa");
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i <= amount; i++) {
            collection.remove("aa");
        }
        long finish = System.currentTimeMillis();
        long result = finish - start;

        return result;
    }

}
