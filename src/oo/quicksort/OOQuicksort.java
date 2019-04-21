package oo.quicksort;

import java.util.function.BiFunction;
import java.util.function.Function;

import app.SearchObject;
import app.TestFunctionality;

public class OOQuicksort extends TestFunctionality {
    public static void quickSort(int[] arr, int left, int right) {
        int divideIndex = divide(arr, left, right);
        if (divideIndex != -1 && left < right) {
            quickSort(arr, left, divideIndex - 1);
            quickSort(arr, divideIndex + 1, right);
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

    }

    private static int divide(int[] arr, int left, int right) {
        if (right < left) {
            return -1;
        }

        int counter = left - 1;

        for (int i = left; i <= right - 1; i++) {
            if (arr[i] <= arr[right]) {
                counter++;
                swap(arr, counter, i);
            }
        }
        swap(arr, (++counter), right);
        return counter;
    }

    /**
     * Swaps any two given values of a given array, elements need to be passed by their indexes
     * @param arr Array to swap the elements on
     * @param a index of the first value 
     * @param b index of the second value
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Takes int  Array and returns true if it's sorted ascended, otherwise returns false
     * @param arr int Array to be checked
     * @return returns true if Array is sorted, otherwise false
     */
    public static boolean isSortedAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Only used for taking the Time it takes to perform a quicksort
     * NOTE: Every time this function is called it newly generates the values in the array
     * Function called in TestAlgorithms
     */
    public static BiFunction<int[], SearchObject, Integer> quicksortTest = (arr, searchObject) -> {
        int[] arr2 = new int[arr.length];
        for(int i = 0; i< arr.length; i++) {
            arr[i] = (int) Math.floor(Math.random() * arr.length);
        }
        quickSort(arr2);
        return -1;
    };
}