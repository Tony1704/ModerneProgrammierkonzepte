package app;

import functional.linearsearch.index.FunctionalLinearSearchTest;
import oo.linearsearch.OOLinearSearchTest;
import oo.quicksort.QuickSortTest;

public class TestAlgorithms {
    private static FunctionalLinearSearchTest functionalLinearSearchTest = new FunctionalLinearSearchTest();
    private static QuickSortTest quicksortTets = new QuickSortTest();
    private static OOLinearSearchTest ooLinearSearchTest = new OOLinearSearchTest();


    public static void runTest() {
        int[] arr = new int[6000];
        int search = 10;
        final int iterations = 1000;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        double[] resultsFunctionalLinearSearch = functionalLinearSearchTest.test(arr, search, arr.length, iterations);
        double[] resultsOOLinearSearch = ooLinearSearchTest.test(arr, search, arr.length, iterations);
        double[] resultsQuickSort = quicksortTets.test(arr, arr.length, iterations);

        System.out.println("Funktionale Lineare Suche: " + resultsFunctionalLinearSearch[0] + "ms");
        System.out.println("OO Lineare Suche: " + resultsOOLinearSearch[0] + "ms");
        System.out.println("OO QuickSort: " + resultsQuickSort[0] + "ms");

    }
}