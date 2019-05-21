package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import functional.linearsearch.index.FunctionalLinearSearchIndex;
import functional.linearsearch.list.FunctionalLinearSearchList;
import multithreaded.linearsearch.index.MultithreadedIndexLinearSearch;
import multithreaded.linearsearch.list.MultithreadedListLinearSearch;
import oo.binarysearch.OOBinarySearch;
import oo.linearsearch.index.OOLinearSearchIndex;
import oo.linearsearch.list.OOLinearSearchList;
import oo.quicksort.OOQuicksort;

public class TestAlgorithms {
        /**
         * Function executes tests on all the algorithms specified in it <p>
         * Calls Functions as defined in {@link TestFunctionality}
         * @return returns an ArrayList<Map<String, Long>> of all test results
         */
        public static ArrayList<Map<String, Long>> runTest() {
                int[] arr = new int[10000];
                final int iterations = 100;

                for (int i = 0; i < arr.length; i++) {
                        arr[i] = (int) Math.floor(Math.random() * arr.length-1);
                }

                SearchObject searchObject = new SearchObject((int) Math.floor(Math.random() * arr.length -1), 10);

                // How to call .test():
                // int Array, int, SearchObject (Contains Search Element, Number of Threads),
                // BiFunction<int[], SearchObject, Integer>
                Map<String, Long> results1 = FunctionalLinearSearchIndex.test(arr, iterations, searchObject,
                                FunctionalLinearSearchIndex.findTest);
                Map<String, Long> results2 = FunctionalLinearSearchList.test(arr, iterations, searchObject,
                                FunctionalLinearSearchList.findFunctional);

                Map<String, Long> results3 = MultithreadedIndexLinearSearch.test(arr, iterations, searchObject,
                                MultithreadedIndexLinearSearch.searchTest);
                Map<String, Long> results4 = MultithreadedListLinearSearch.test(arr, iterations, searchObject,
                                MultithreadedListLinearSearch.searchTest);

                Map<String, Long> results5 = OOLinearSearchIndex.test(arr, iterations, searchObject,
                                OOLinearSearchIndex.searchTest);

                Map<String, Long> results6 = OOLinearSearchList.test(arr, iterations, searchObject,
                                OOLinearSearchList.searchTest);

                long [] iterationresult = new long[iterations];
                int [] copyArr = new int [10000];

                for (int i = 0; i<iterations; i++) {
                        /*for (int j = 0; j < arr.length; j++) {
                                arr[j] = (int) Math.floor(Math.random() * arr.length + 1);
                        }*/
                        copyArr = Arrays.copyOf(arr, arr.length);
                        Map<String, Long> iteratormap = OOQuicksort.test(copyArr, 1, searchObject, OOQuicksort.quicksortTest);
                        iterationresult[i] = iteratormap.get("total_time");
                }
                Map<String, Long> results7 = MapBauer(iterationresult);

                Map<String, Long> results8 = OOBinarySearch.test(arr, iterations, searchObject, OOBinarySearch.binarysearchTest);

                ArrayList<Map<String, Long>> list = new ArrayList<>();
                list.add(results1);
                list.add(results2);
                list.add(results3);
                list.add(results4);
                list.add(results5);
                list.add(results6);
                list.add(results7);
                list.add(results8);

                return list;
        }

        public static Map<String, Long> MapBauer (long[] iterationresults) {
                Map<String, Long> returnValues = new TreeMap<String, Long>();
                Arrays.sort(iterationresults);

                long total_time = 0;
                for (int i = 0; i < iterationresults.length; i++) {
                        total_time += (iterationresults[i]/1000);
                }

                returnValues.put("total_time", (total_time/iterationresults.length));
                returnValues.put("min_time", iterationresults[0]/1000);
                returnValues.put("max_time", iterationresults[iterationresults.length-1]/1000);

                return returnValues;
        }

}