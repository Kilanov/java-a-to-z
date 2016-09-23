package ru.skilanov.triangle;

import java.util.Arrays;

/**
 * Find max side of the triangle.
 */
public class TriangleMaxSide {
    public double max(double... nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
}