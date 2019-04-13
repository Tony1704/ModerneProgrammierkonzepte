package app;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Testable {

    // Test Function for Search Algorithms
    public static Map<String, Long> test(int[] arr, int search, int iterations, BiFunction<int[], Integer, Integer> function) {
        Map<String, Long> returnValues = new TreeMap<>();
        long totalTimeStart = System.nanoTime();
        long maxTime = Long.MIN_VALUE;
        long minTime = Long.MAX_VALUE;

        for(int i = 0; i < iterations; i++) {
            long currentTimeStart = System.nanoTime();
            function.apply(arr, search);
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

    // Test Function for Sorting Algorithms
    public static Map<String, Long> test(int[] arr, int iterations, Function<int[], Integer> function) {
        Map<String, Long> returnValues = new TreeMap<>();
        long totalTimeStart = System.nanoTime();
        long maxTime = Long.MIN_VALUE;
        long minTime = Long.MAX_VALUE;

        for(int i = 0; i < iterations; i++) {
            long currentTimeStart = System.nanoTime();
            function.apply(arr);
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

    // Test Function for Mulithreaded Search Functions
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