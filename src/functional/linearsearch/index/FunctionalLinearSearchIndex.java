package functional.linearsearch.index;

import java.util.stream.IntStream;

import app.SearchObject;
import app.TestFunctionality;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class FunctionalLinearSearchIndex extends TestFunctionality {
    /**
     * linear search realised by functional programming
     */
    private static FunctionalLinearSearchIndexInterface linearSearch = (intArr, intSearch) -> {
        try {
            return IntStream
                    .range(0, intArr.length)
                    .filter(i -> intArr[i] == intSearch)
                    .findFirst()
                    .getAsInt();
        } catch (NoSuchElementException e) {
            return -1;
        }
    };

    /**
     * starts the functional linear search function
     * @param arr the array to be searched
     * @param searchInt the int to be found
     * @return returns index of int if found. If the int is not the array, the function returns -1.
     */
    public static int findLin(int[] arr, int searchInt) {
        return linearSearch.search(arr, searchInt);
    }


    /**
     *  Only used for taking the Time it takes to perform a quicksort
     *  Function called in TestAlgorithms
     */
    public static BiFunction<int[], SearchObject, Integer> findTest = (arr, searchObject) -> {
        return linearSearch.search(arr, (int) searchObject.search);
    };


}