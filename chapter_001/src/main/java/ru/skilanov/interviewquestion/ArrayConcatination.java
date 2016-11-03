package ru.skilanov.interviewquestion;

public class ArrayConcatination {
    public int[] concatination(int[] two, int[] one) {
        int[] three = new int[one.length + two.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < one.length && j < two.length) {
            if (one[i] < two[j]) {
                three[index] = one[i];
                i++;
            } else {
                three[index] = two[j];
                j++;
            }

            index++;
        }
        while (i < one.length) {
            three[index] = one[i];
            index++;
            i++;
        }

        while (j < two.length) {
            three[index] = two[j];
            index++;
            j++;
        }
        return three;
    }
}