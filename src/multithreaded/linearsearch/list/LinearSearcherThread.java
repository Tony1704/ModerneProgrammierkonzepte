package multithreaded.linearsearch.list;

import java.util.*;

public class LinearSearcherThread implements Runnable
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
    public LinearSearcherThread(int[] pSearchArray, int pSearchElement, int pStart, int pEnd)
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
     * @return returns indexlist of results
     */
    public List<Integer> getIndexList()
    {
        Collection<Integer> lValues = resultMap.values();
        List<Integer> lResultList = new ArrayList<>(lValues);

        return lResultList;
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
