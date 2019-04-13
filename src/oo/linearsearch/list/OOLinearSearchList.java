package oo.linearsearch.list;

import java.util.ArrayList;
import java.util.List;

public class OOLinearSearchList {
    static List findInt(int[] arr, int search) {

        List<Integer> list = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                list.add(i);
            }
        }
        return list;
    }
}
