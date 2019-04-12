package oop.quicksort;

import app.SortTestable;

public class QuickSortTest implements SortTestable {

    @Override
    public double[] test(int[] arr, int numberOfElements, int iterations) {
        double[] returnValue = new double[1];

        long lowestTime = Long.MAX_VALUE;
        long lastTime = 0l;

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            Sorter.quickSort(arr);
            long endTime = System.nanoTime();
            lastTime = (endTime - startTime);
            if (lastTime == lowestTime) {
                lowestTime = lastTime;
            }
        }
        returnValue[0] = (double) lastTime;

        return returnValue;
    }

}