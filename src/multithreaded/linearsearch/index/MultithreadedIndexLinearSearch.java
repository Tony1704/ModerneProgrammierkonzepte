package multithreaded.linearsearch.index;

import app.SearchObject;
import app.TestFunctionality;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class MultithreadedIndexLinearSearch extends TestFunctionality
{
    /**
     * Search function of linear search multithreaded
     * @param pSearchArray Array to be searched
     * @param pSearchElement Element to be found
     * @param pThreads Threads to be used
     * @return returns index of element if found. If the Element is not in the array, return is -1.
     */
    public int search(int[] pSearchArray, int pSearchElement, int pThreads)
    {
        Thread[] lThreadArray = new Thread[pThreads];
        LinearSearchThread[] lLinearSearcherArray = new LinearSearchThread[pThreads];

        boolean lIsReady = false;
        int lScale = pSearchArray.length / pThreads;
        int lLastI = 0;

        //splits the array up into the theats
        for(int i = 0; i < (pThreads - 1); i++)
        {
            lLinearSearcherArray[i] = new LinearSearchThread(pSearchArray, pSearchElement, lLastI, (lLastI + lScale));
            lThreadArray[i] = new Thread(lLinearSearcherArray[i]);
            lThreadArray[i].start();

            lLastI += lScale;
        }

        lLinearSearcherArray[pThreads-1] = new LinearSearchThread(pSearchArray, pSearchElement, lLastI, pSearchArray.length);

        lThreadArray[pThreads-1] = new Thread(lLinearSearcherArray[pThreads-1]);
        lThreadArray[pThreads-1].start();

        //waiting for the threads
        while(!lIsReady)
        {
            if(this.threadsReady(lLinearSearcherArray))
            {
                lIsReady = true;
            }
        }

        int lIndex = -1;

        try
        {
            lIndex = lLinearSearcherArray[0].getIndex();
        }
        catch (NoSuchElementException ex)
        {
            lIndex = -1;
        }


        return lIndex;
    }

    /**
     * Determines the readiness states of all the threads
     * @param pSearcher array of threads
     * @return returns readiness state of arrays
     */
    private boolean threadsReady(LinearSearchThread[] pSearcher) {
        for (int j = 0; j < pSearcher.length; j++) {
            if (!pSearcher[j].isReady()) {
                return false;
            }
        }

        return true;
    }

    public static BiFunction<int[], SearchObject, Integer> searchTest = (arr, searchObject) -> {
        MultithreadedIndexLinearSearch l = new MultithreadedIndexLinearSearch();
        l.search(arr, searchObject.search, searchObject.numberOfThreads);
        return -1;
    };
}
