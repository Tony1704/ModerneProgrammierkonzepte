package functional.linearsearch.returnindex;

import app.SearchTestable;


public class FunctionalLinearSearchTest implements SearchTestable {

    @Override
    public double[] test(int[] arr, int search) {
        double[] returnValue = new double[1];

        long startTime = System.nanoTime();
        LinearSearch.findLin(arr, search);
        long endTime = System.nanoTime();

        returnValue[0] = (double) (endTime - startTime) / 1000000;

        return returnValue;

    }

}