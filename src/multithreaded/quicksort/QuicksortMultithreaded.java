package multithreaded.quicksort;
import app.SearchObject;
import app.TestFunctionality;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

public class QuicksortMultithreaded extends TestFunctionality
{
    /**
     * Creates an object of type Sorter and sorts the given array
     * @param arr int array, passed by reference
     * @param threads number of max Threads used for sorting
     */
    public static void quickSort(int[] arr, int threads)
    {
        final AtomicInteger lThreadCounter = new AtomicInteger(1);
        Sorter lThread = new Sorter(arr, 0, arr.length-1, lThreadCounter, threads);
        lThread.run();
        try {
            synchronized (lThreadCounter)
            {
                lThreadCounter.wait();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Only used for taking the time it takes to perform a quicksort
     * Function called in TestAlgorithms
     */
    public static BiFunction<int[], SearchObject, Integer> quicksortTest = (arr, searchObject) -> {
        quickSort(arr, searchObject.numberOfThreads);
        return -1;
    };
}
