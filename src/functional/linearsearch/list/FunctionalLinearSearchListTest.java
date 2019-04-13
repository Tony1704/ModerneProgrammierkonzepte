package functional.linearsearch.list;

import app.SearchTestable;
import java.util.List;

public class FunctionalLinearSearchListTest implements SearchTestable {

    @Override
    public double[] test(int[] arr, int search, int numberOfElements, int iterations) {

        double[] returnValue = new double[1];

        long lowestTime = Long.MAX_VALUE;
        long lastTime = 0l;

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            List list = LinearSearch.searchint(arr, 1);
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

