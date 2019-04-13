package oo.linearsearch.index;

import app.Testable;
import java.util.function.BiFunction;

public class OOLinearSearchIndex extends Testable {
    static int findInt(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                return i;
            }
        }
        return -1;
    }

    public static BiFunction<int[], Integer, Integer> searchTest = (arr, search) -> {
        findInt(arr, search);
        return -1;
    };
}