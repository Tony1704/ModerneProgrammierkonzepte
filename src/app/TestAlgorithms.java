package app;

import java.util.Map;

public class TestAlgorithms {
    public static void runTest() {
        int[] arr = new int[6000];
        int search = 10;
        final int iterations = 1000;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        Map<String, Long> results1 = functional.linearsearch.index.LinearSearch.test(arr, search, arr.length, iterations, functional.linearsearch.index.LinearSearch.findTest);
        Map<String, Long> results2 = oo.quicksort.Quicksort.test(arr, arr.length, iterations, oo.quicksort.Quicksort.quicksortTest);

    }
}