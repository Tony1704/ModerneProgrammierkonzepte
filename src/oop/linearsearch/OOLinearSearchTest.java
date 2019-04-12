package oop.linearsearch;

import app.SearchTestable;

public class OOLinearSearchTest implements SearchTestable {
    @Override
    public double[] test(int[] arr, int search, int numberOfElements, int iterations) {
        double[] returnValue = new double[1];

        long lowestTime = Long.MAX_VALUE;
        long lastTime = 0l;

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            LinearSearch.findInt(arr, search);
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