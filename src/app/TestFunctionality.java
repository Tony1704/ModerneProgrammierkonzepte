package app;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;

abstract public class TestFunctionality {

    /**
     * Takes in arguments to run the test function on an Algorithm from a class that extends the TestFunctionality Class
     * @param arr int Array that is used to run the Test on (Note: For sorting Algorithms this has to be reshuffled in the testing Function)
     * @param iterations number of times the test will run
     * @param searchObject Object containing the integer to be searched and the number of threads (only relevant for multithreaded algorithms)
     * @param function Specified Test Function (BiFunction<int[], SearchObject, Integer> that needs to be defined in the Class of the Algortihms that needs will be tested)
     * @return returns a Map<String, Long> with the Testing Times ("total_time", "min_time", "max_time")
     */
    public static Map<String, Long> test(int[] arr, int iterations, SearchObject searchObject, BiFunction<int[], SearchObject, Integer> function) {
        Map<String, Long> returnValues = new TreeMap<>();
        long totalTimeStart = System.nanoTime();
        long maxTime = Long.MIN_VALUE;
        long minTime = Long.MAX_VALUE;

        for(int i = 0; i < iterations; i++) {
            long currentTimeStart = System.nanoTime();
            function.apply(arr, searchObject);
            long currentTimeEnd = System.nanoTime();
            if(currentTimeEnd - currentTimeStart < minTime) {
                minTime = currentTimeEnd - currentTimeStart;
            }
            if(currentTimeEnd - currentTimeStart > maxTime) {
                maxTime = currentTimeEnd - currentTimeStart;
            }
        }

        long totalTimeEnd = System.nanoTime();
        returnValues.put("total_time", (totalTimeEnd - totalTimeStart));
        returnValues.put("min_time", minTime);
        returnValues.put("max_time", maxTime);
        return returnValues;
    }
}