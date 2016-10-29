package ru.skilanov.interviewquestion;

public class ArrayConcatination {
    public int[] concatination(int[] two, int[] one) {
        int[] three = new int[two.length + one.length];
        if (one[0] > two[0]) {
            System.arraycopy(one, 0, three, 0, one.length);
            System.arraycopy(two, 0, three, one.length, two.length);
        } else {
            System.arraycopy(two, 0, three, 0, two.length);
            System.arraycopy(one, 0, three, two.length, one.length);
        }
        return three;
    }
}