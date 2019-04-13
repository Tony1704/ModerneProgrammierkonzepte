package oo.quicksort;

public class OOQuicksort {
    private static long bComparisons = 0;
    private static long bArrayAccesses = 0;

    private static long qComparisons = 0;
    private static long qArrayAccesses = 0;
    private static long qFunctionsCalls = 0;
    private static long qdivideCalls = 0;

    public static void quickSort(int[] arr, int left, int right) {
        int divideIndex = divide(arr, left, right);
        if (divideIndex != -1 && left < right) {
            qFunctionsCalls++;
            quickSort(arr, left, divideIndex - 1);
            qFunctionsCalls++;
            quickSort(arr, divideIndex + 1, right);
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

        // System.out.println("Function Calls (Quick): " + qFunctionsCalls);
        // System.out.println("Comparsions (Quick): " + qComparisons);
        // System.out.println("Array Accesses (Quick): " + qArrayAccesses);
        // System.out.println("Divide Calls (Quick): " + qdivideCalls);
    }

    public static int divide(int[] arr, int left, int right) {
        qdivideCalls++;
        if (right < left) {
            return -1;
        }

        int counter = left - 1;

        for (int i = left; i <= right - 1; i++) {
            qComparisons++;
            if (arr[i] <= arr[right]) {
                counter++;
                qArrayAccesses++;
                swap(arr, counter, i);
            }
        }

        swap(arr, (++counter), right);
        return counter;

    }

    // Bubble Sort for some testing
    public static void bubbleSort(int[] arr) {
        boolean hasChanged = true;
        for (int i = 0; i < arr.length - 1 && hasChanged; i++) {
            hasChanged = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                bComparisons++;
                if (arr[j] > arr[j + 1]) {
                    bArrayAccesses++;
                    swap(arr, j, j + 1);
                    hasChanged = true;
                }
            }
        }

        // System.out.println("Comparsions (Bubble): " + bComparisons);
        // System.out.println("Array Accesses (Bubble): " + bArrayAccesses);

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
}