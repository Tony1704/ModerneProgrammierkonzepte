package oo.linearsearch.index;

import app.SearchObject;
import app.TestFunctionality;
import java.util.function.BiFunction;

public class OOLinearSearchIndex extends TestFunctionality {
    static int findInt(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                return i;
            }
        }
        return -1;
    }

    public static BiFunction<int[], SearchObject, Integer> searchTest = (arr, searchObject) -> {
        findInt(arr, searchObject.search);
        return -1;
    };
}