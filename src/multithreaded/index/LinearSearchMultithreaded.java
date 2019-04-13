package multithreaded.index;

import java.util.NoSuchElementException;

public class LinearSearchMultithreaded
{
    private int threads = 1;
    private int[] searchArray;

    public LinearSearchMultithreaded(int[] pSearchArray)
    {
        searchArray = pSearchArray;
    }

    public LinearSearchMultithreaded(int[] pSearchArray, int pThreads)
    {
        searchArray = pSearchArray;
        threads = pThreads;
    }

    public int search(int pSearchElement)
    {
        Thread[] lThreadArray = new Thread[threads];
        LinearSearcherThread[] lLinearSearcherArray = new LinearSearcherThread[threads];

        boolean lIsReady = false;
        int lScale = searchArray.length / threads;
        int lLastI = 0;

        for(int i = 0; i < (threads - 1); i++)
        {
            lLinearSearcherArray[i] = new LinearSearcherThread(searchArray, pSearchElement, lLastI, (lLastI + lScale));
            lThreadArray[i] = new Thread(lLinearSearcherArray[i]);
            lThreadArray[i].start();

            lLastI += lScale;
        }

        lLinearSearcherArray[threads-1] = new LinearSearcherThread(searchArray, pSearchElement, lLastI, searchArray.length);

        lThreadArray[threads-1] = new Thread(lLinearSearcherArray[threads-1]);
        lThreadArray[threads-1].start();

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
//new Line
}
