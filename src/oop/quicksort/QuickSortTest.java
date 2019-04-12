package oop.quicksort;

import app.SortTestable;

public class QuickSortTest implements SortTestable {

    @Override
    public double[] test(int[] arr) {
        double[] returnValue = new double[1];

        long startTime = System.nanoTime();
        Sorter.quickSort(arr);
        long endTime = System.nanoTime();

        returnValue[0] = (double) (endTime - startTime) / 1000000;

        return returnValue;

    }

}