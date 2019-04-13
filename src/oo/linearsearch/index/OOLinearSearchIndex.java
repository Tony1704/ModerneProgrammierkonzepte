package oo.linearsearch.index;

public class OOLinearSearchIndex {
    static int findInt(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                return i;
            }
        }
        return -1;
    }
}