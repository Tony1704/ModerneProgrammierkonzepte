package functional.linearsearch.returnindex;

import app.SearchTestable;

public class FunctionalLinearSearchTest implements SearchTestable {

    @Override
    public double[] test(int[] arr, int search, int numberOfElements, int iterations) {
        double[] returnValue = new double[1];

        long lowestTime = Long.MAX_VALUE;
        long lastTime = 0l;

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            LinearSearch.findLin(arr, search);
            long endTime = System.nanoTime();
            lastTime = (endTime - startTime);
            if (lastTime == lowestTime) {
                lowestTime = lastTime;
            }
        }
        returnValue[0] = (double) lastTime / 1000000;

        return returnValue;

    }

}