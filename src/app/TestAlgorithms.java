package app;

import java.util.Map;

import functional.linearsearch.index.FunctionalLinearSearchIndex;
import oo.quicksort.OOQuicksort;


public class TestAlgorithms {
    public static void runTest() {
        int[] arr = new int[6000];
        int search = 10;
        final int iterations = 1000;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // Map<String, Long> results1 = FunctionalLinearSearchIndex.test(arr, search,  iterations, FunctionalLinearSearchIndex.findTest);
        // Map<String, Long> results2 = OOQuicksort.test(arr, iterations, OOQuicksort.quicksortTest);

    }
}