package oo.linearsearch.list;

import app.SearchObject;
import app.TestFunctionality;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class OOLinearSearchList extends TestFunctionality {

    /**
     * Searches the given array for elements that can be matched
     * @param arr array to be searched
     * @param search element to be put in list
     * @return list of indexes of matched results
     */
    static List<Integer> findInt(int[] arr, int search) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                list.add(i);
            }
        }
        return list;
    }

    public static BiFunction<int[], SearchObject, Integer> searchTest = (arr, searchObject) -> {
        findInt(arr, searchObject.search);
        return -1;
    };
}
