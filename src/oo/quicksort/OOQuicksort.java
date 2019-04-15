package oo.quicksort;

import java.util.function.BiFunction;
import java.util.function.Function;

import app.SearchObject;
import app.Testable;

public class OOQuicksort extends Testable {
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

    public static int divide(int[] arr, int left, int right) {
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

    // Swaps two values of an array given the array and two indexes
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // checks if a given array is sorted ascending
    public static boolean isSortedAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static BiFunction<int[], SearchObject, Integer> quicksortTest = (arr, searchObject) -> {
        int[] arr2 = new int[arr.length];
        for(int i = 0; i< arr.length; i++) {
            arr[i] = (int) Math.floor(Math.random() * arr.length);
        }
        quickSort(arr2);
        return -1;
    };
}