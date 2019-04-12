package oop.linearsearch;

import app.SearchTestable;

public class OOLinearSearchTest implements SearchTestable {
    @Override
    public double[] test(int[] arr, int search) {
        double[] returnValue = new double[1];
        long startTime = System.nanoTime();
        LinearSearch.findInt(arr, search);
        long endTime = System.nanoTime();

        returnValue[0] = (double) (endTime - startTime) / 1000000;

        return returnValue;
        
    }
}