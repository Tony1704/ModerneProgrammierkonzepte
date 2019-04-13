package app;

import java.util.ArrayList;
import java.util.Map;

import functional.linearsearch.index.FunctionalLinearSearchIndex;
import multithreaded.linearsearch.index.LinearSearchMultithreaded;
import oo.quicksort.OOQuicksort;


public class TestAlgorithms {
    public static ArrayList<Map<String, Long>> runTest() {
        int[] arr = new int[6000];
        int search = 10;
        final int iterations = 1000;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        Map<String, Long> results1 = FunctionalLinearSearchIndex.test(arr, search, iterations, FunctionalLinearSearchIndex.findTest);
        Map<String, Long> results2 = OOQuicksort.test(arr, iterations, OOQuicksort.quicksortTest);
        Map<String, Long> results3 = LinearSearchMultithreaded.test(arr, iterations, new SearchObject(10, 10), LinearSearchMultithreaded.searchTest);

        ArrayList<Map<String, Long>> list = new ArrayList<>();
        list.add(results1);
        list.add(results2);
        list.add(results3);

        return list;
    }
}