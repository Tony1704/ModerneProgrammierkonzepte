package multithreaded.linearsearch.index;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class LinearSearchThread implements Runnable
{
    private int[] searchArray;

    private int searchElement;
    private int start;
    private int end;

    private static volatile SortedMap<Integer, Integer> resultMap = Collections.synchronizedSortedMap(new TreeMap<>());

    private boolean isReady;

    /**
     *
     * @param pSearchArray array to be searched
     * @param pSearchElement element to be found
     * @param pStart start of area thats being searched by this thread
     * @param pEnd end of area thats being searched by this thread
     */
    public LinearSearchThread(int[] pSearchArray, int pSearchElement, int pStart, int pEnd)
    {
        searchArray = pSearchArray;
        searchElement = pSearchElement;
        start = pStart;
        end = pEnd;
        isReady = false;
    }

    /**
     * Main function for the search process
     */
    @Override
    public void run()
    {
        for(int i = start; i < end; i++)
        {
            if(searchArray[i] == searchElement)
            {
                resultMap.put(i,i);
            }
        }

        isReady = true;
    }

    /**
     *
     * @return returns the first key of the result map
     */
    public int getIndex()
    {
        return resultMap.firstKey();
    }

    /**
     *
     * @return returns readiness of the thread
     */
    public boolean isReady()
    {
        return isReady;
    }
}
