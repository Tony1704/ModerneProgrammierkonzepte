package app;

import java.util.ArrayList;
import java.util.Map;

import functional.linearsearch.index.FunctionalLinearSearchIndex;
import functional.linearsearch.list.FunctionalLinearSearchList;
import multithreaded.linearsearch.index.MultithreadedIndexLinearSearch;
import multithreaded.linearsearch.list.MultithreadedListLinearSearch;
import oo.linearsearch.index.OOLinearSearchIndex;
import oo.linearsearch.list.OOLinearSearchList;
import oo.quicksort.OOQuicksort;

public class TestAlgorithms {
        /**
         * Function executes tests on all the algorithms specified in it
         * @return returns an ArrayList<Map<String, Long>> of all test results
         */
        public static ArrayList<Map<String, Long>> runTest() {
                int[] arr = new int[6000];
                int search = (int) Math.random() * arr.length;
                final int iterations = 100;

                for (int i = 0; i < arr.length; i++) {
                        arr[i] = (int) Math.random() * arr.length;
                }
                SearchObject searchObject = new SearchObject(arr.length / 2, 10);

                // How to call .test():
                // int Array, int, SearchObject (Contains Search Element, Number of Threads),
                // BiFunction<int[], SearchObject, Integer>
                Map<String, Long> results1 = FunctionalLinearSearchIndex.test(arr, iterations, searchObject,
                                FunctionalLinearSearchIndex.findTest);
                Map<String, Long> results2 = FunctionalLinearSearchList.test(arr, iterations, searchObject,
                                FunctionalLinearSearchList.findFunctional);

                Map<String, Long> results4 = MultithreadedIndexLinearSearch.test(arr, iterations, searchObject,
                                MultithreadedIndexLinearSearch.searchTest);
                Map<String, Long> results5 = MultithreadedListLinearSearch.test(arr, iterations, searchObject,
                                MultithreadedListLinearSearch.searchTest);

                Map<String, Long> results6 = OOLinearSearchIndex.test(arr, iterations, searchObject,
                                OOLinearSearchIndex.searchTest);
                Map<String, Long> results7 = OOLinearSearchList.test(arr, iterations, searchObject,
                                OOLinearSearchList.searchTest);

                Map<String, Long> results3 = OOQuicksort.test(arr, iterations, searchObject, OOQuicksort.quicksortTest);

                ArrayList<Map<String, Long>> list = new ArrayList<>();
                list.add(results1);
                list.add(results2);
                list.add(results3);
                list.add(results4);
                list.add(results5);
                list.add(results6);
                list.add(results7);

                return list;
        }
}