package app;

import functional.linearsearch.index.FunctionalLinearSearchIndexTest;
import functional.linearsearch.list.FunctionalLinearSearchListTest;
import oo.linearsearch.OOLinearSearchTest;
import oo.quicksort.QuickSortTest;

public class TestAlgorithms {
    private static FunctionalLinearSearchIndexTest functionalLinearSearchIndexTest = new FunctionalLinearSearchIndexTest();
    private static FunctionalLinearSearchListTest functionalLinearSearchListTest = new FunctionalLinearSearchListTest();
    private static QuickSortTest quicksortTets = new QuickSortTest();
    private static OOLinearSearchTest ooLinearSearchTest = new OOLinearSearchTest();


    public static void runTest() {
        int[] arr = new int[50];
        int search = 10;
        final int iterations = 50;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        double[] resultsFunctionalLinearSearchIndex = functionalLinearSearchIndexTest.test(arr, search, arr.length, iterations);
        double[] resultsFunctionalLinearSearchList = functionalLinearSearchListTest.test(arr, search, arr.length, iterations);
        double[] resultsOOLinearSearch = ooLinearSearchTest.test(arr, search, arr.length, iterations);
        double[] resultsQuickSort = quicksortTets.test(arr, arr.length, iterations);

        System.out.println("Funktionale Lineare Suche Index: " + resultsFunctionalLinearSearchIndex[0] + "ms");
        System.out.println("Funktionale Lineare Suche List: " + resultsFunctionalLinearSearchList[0] + "ms");
        System.out.println("OO Lineare Suche: " + resultsOOLinearSearch[0] + "ms");
        System.out.println("OO QuickSort: " + resultsQuickSort[0] + "ms");

    }
}