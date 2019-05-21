package multithreaded.quicksort;

import java.util.concurrent.atomic.AtomicInteger;

public class Sorter implements Runnable
{
    private final int[] zArr;
    private final int zLeft, zRight;
    private final AtomicInteger zThreadCounter;

    private final int zMaxThreads;

    /**
     * Pass function an (unsorted) int Array, a left index, a right index,
     * the AtomicInteger used for Threads and the max number of Threads
     * @param arr (unsorted) int Array
     * @param left left index
     * @param right right index
     * @param counter Thread counter
     * @param threads max Threads
     *
     */
    public Sorter(int[] arr, int left, int right, AtomicInteger counter, int threads)
    {
        zArr = arr;
        zLeft = left;
        zRight = right;
        zThreadCounter = counter;
        zMaxThreads = threads;
    }

    /**
     * Method to create new Threads
     * uses the class attributes for sorting
     */
    @Override
    public void run()
    {
        quicksort(zLeft, zRight);
        synchronized (zThreadCounter)
        {
            if(zThreadCounter.getAndDecrement() == 1)
            {
                zThreadCounter.notify();
            }
        }
    }

    /**
     * The main sort method
     * @param left
     * @param right
     */
    private void quicksort(int left, int right)
    {
        if(left < right)
        {
            int divideIndex = divide(left, right);

            if(zThreadCounter.get() > zMaxThreads)
            {
                quicksort(left, divideIndex - 1);
                quicksort(divideIndex + 1, right);
            }

            else
            {
                zThreadCounter.getAndAdd(2);
                Thread lLeft = new Thread(new Sorter(zArr, left, divideIndex - 1, zThreadCounter, zMaxThreads));
                Thread lRight = new Thread(new Sorter(zArr, divideIndex + 1, right, zThreadCounter, zMaxThreads));

                lLeft.start();
                lRight.start();
            }
        }
    }

    /**
     * Iterates through the array and swaps larger elements to the right
     * @param left start of section that needs to be looked at
     * @param right end of section that needs to be looked at
     * @return returns the number of elements swapped (see quick sort algorithms for that)
     */
    private int divide(int left, int right) {
        if (right < left) {
            return -1;
        }

        int counter = left - 1;

        for (int i = left; i <= right - 1; i++) {
            if (zArr[i] <= zArr[right]) {
                counter++;
                swap(counter, i);
            }
        }
        swap((++counter), right);
        return counter;
    }

    /**
     * Swaps any two given values of a given array, elements need to be passed by their indexes
     * @param a index of the first value
     * @param b index of the second value
     */
    private void swap(int a, int b) {
        int temp = zArr[a];
        zArr[a] = zArr[b];
        zArr[b] = temp;
    }
}
