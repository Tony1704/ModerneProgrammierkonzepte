package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import functional.linearsearch.index.FunctionalLinearSearchIndex;
import functional.linearsearch.list.FunctionalLinearSearchList;
import multithreaded.linearsearch.index.MultithreadedIndexLinearSearch;
import multithreaded.linearsearch.list.MultithreadedListLinearSearch;
import multithreaded.quicksort.QuicksortMultithreaded;
import oo.binarysearch.OOBinarySearch;
import oo.linearsearch.index.OOLinearSearchIndex;
import oo.linearsearch.list.OOLinearSearchList;
import oo.quicksort.OOQuicksort;

public class TestAlgorithms {
        /**
         * Function executes tests with all the algorithms specified in it <p>
         * Calls Functions as defined in {@link TestFunctionality}
         * @return returns an ArrayList<Map<String, Long>> with all test results in it
         */
        public static ArrayList<Map<String, Long>> runTest() {
                int[] arr = new int[100000];
                final int iterations = 100;

                //generates our test array
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
                int [] copyArr = new int [500000];

                for (int i = 0; i<iterations; i++) {
                        copyArr = Arrays.copyOf(arr, arr.length);
                        Map<String, Long> iteratormap = OOQuicksort.test(copyArr, 1, searchObject, OOQuicksort.quicksortTest);
                        iterationresult[i] = iteratormap.get("total_time");
                }
                Map<String, Long> results7 = MapBuilder(iterationresult);

                iterationresult = new long[iterations];
                copyArr = new int [100000];

                for (int i = 0; i<iterations; i++) {
                        //necessary to have a value and not a reference of the object. For comparability.
                        copyArr = Arrays.copyOf(arr, arr.length);
                        Map<String, Long> iteratormap = OOQuicksort.test(copyArr, 1, searchObject, QuicksortMultithreaded.quicksortTest);
                        iterationresult[i] = iteratormap.get("total_time");
                }
                Map<String, Long> results8 = MapBuilder(iterationresult);

                Map<String, Long> results9 = OOBinarySearch.test(arr, iterations, searchObject, OOBinarySearch.binarysearchTest);

                ArrayList<Map<String, Long>> list = new ArrayList<>();
                list.add(results1);
                list.add(results2);
                list.add(results3);
                list.add(results4);
                list.add(results5);
                list.add(results6);
                list.add(results7);
                list.add(results8);
                list.add(results9);

                return list;
        }

        /**
         * fills the map with the quicksort test result
         * @param iterationresults array of long variable that represent the test results
         * @return returns the map filled with test results
         */
        public static Map<String, Long> MapBuilder (long[] iterationresults) {
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