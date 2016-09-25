package ru.skilanov.triangle;

import java.util.Arrays;

/**
 * Find max side of the triangle.
 */
public class TriangleMaxSide {
    public double max(double... nums) {
        double maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }
        return maxValue;
    }
}