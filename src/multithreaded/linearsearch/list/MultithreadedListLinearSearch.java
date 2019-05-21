package multithreaded.linearsearch.list;

import java.util.List;
import java.util.function.BiFunction;
import app.SearchObject;
import app.TestFunctionality;

public class MultithreadedListLinearSearch extends TestFunctionality
{
    /**
     * Search function of linear search multithreaded
     * @param pSearchArray Array to be searched
     * @param pSearchElement Element to be found
     * @param pThreads Threads to be used
     * @return returns index of element if found. If the Element is not in the array, return is -1.
     */
    public List<Integer> search(int[] pSearchArray, int pSearchElement, int pThreads)
    {
        Thread[] lThreadArray = new Thread[pThreads];
        LinearSearcherThread[] lLinearSearcherArray = new LinearSearcherThread[pThreads];

        boolean lIsReady = false;
        int lScale = pSearchArray.length / pThreads;
        int lLastI = 0;

        for(int i = 0; i < (pThreads - 1); i++)
        {
            lLinearSearcherArray[i] = new LinearSearcherThread(pSearchArray, pSearchElement, lLastI, (lLastI + lScale));
            lThreadArray[i] = new Thread(lLinearSearcherArray[i]);
            lThreadArray[i].start();

            lLastI += lScale;
        }

        lLinearSearcherArray[pThreads-1] = new LinearSearcherThread(pSearchArray, pSearchElement, lLastI, pSearchArray.length);

        lThreadArray[pThreads-1] = new Thread(lLinearSearcherArray[pThreads-1]);
        lThreadArray[pThreads-1].start();

        while(!lIsReady)
        {
            if(this.threadsReady(lLinearSearcherArray))
            {
                lIsReady = true;
            }
        }

        return lLinearSearcherArray[0].getIndexList();
    }
    /**
     * Determines the readiness states of all the threads
     * @param pSearcher array of threads
     * @return returns readiness state of arrays
     */
    private boolean threadsReady(LinearSearcherThread[] pSearcher) {
        for (int j = 0; j < pSearcher.length; j++) {
            if (!pSearcher[j].isReady()) {
                return false;
            }
        }

        return true;
    }

    public static BiFunction<int[], SearchObject, Integer> searchTest = (arr, searchObject) -> {
        MultithreadedListLinearSearch l = new MultithreadedListLinearSearch();
        l.search(arr, searchObject.search, searchObject.numberOfThreads);
        return -1;
    };

}

