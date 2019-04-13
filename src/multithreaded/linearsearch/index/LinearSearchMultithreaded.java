package multithreaded.linearsearch.index;

import app.SearchObject;
import app.Testable;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class LinearSearchMultithreaded extends Testable
{
    public int search(int[] pSearchArray, int pSearchElement, int pThreads)
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

    private boolean threadsReady(LinearSearcherThread[] pSearcher) {
        for (int j = 0; j < pSearcher.length; j++) {
            if (!pSearcher[j].isReady()) {
                return false;
            }
        }

        return true;
    }

    public static BiFunction<int[], SearchObject, Integer> searchTest = (arr, searchObject) -> {
        LinearSearchMultithreaded l = new LinearSearchMultithreaded();
        l.search(arr, searchObject.search, searchObject.numberOfThreads);
        return -1;
    };
}
