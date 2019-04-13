package oo.linearsearch.index;

import java.util.function.BiFunction;

import app.Testable;

public class OOLinearSearchIndex extends Testable{
    static int findInt(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                return i;
            }
        }
        return -1;
    }

    public static BiFunction<int[], Integer, Integer> findTest = (arr, searchInt) -> {
        return findInt(arr, (int) searchInt);
    };
}