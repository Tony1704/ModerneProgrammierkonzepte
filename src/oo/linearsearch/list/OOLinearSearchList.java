package oo.linearsearch.list;

import app.Testable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class OOLinearSearchList extends Testable {
    static List findInt(int[] arr, int search) {

        List<Integer> list = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                list.add(i);
            }
        }
        return list;
    }

    public static BiFunction<int[], Integer, Integer> searchTest = (arr, search) -> {
        findInt(arr, search);
        return -1;
    };
}
