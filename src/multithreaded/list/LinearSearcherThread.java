package multithreaded.list;

import java.util.*;

public class LinearSearcherThread implements Runnable
{
    private int[] searchArray;

    private int searchElement;
    private int start;
    private int end;

    private static volatile SortedMap<Integer, Integer> resultMap = Collections.synchronizedSortedMap(new TreeMap<>());

    private boolean isReady;

    public LinearSearcherThread(int[] pSearchArray, int pSearchElement, int pStart, int pEnd)
    {
        searchArray = pSearchArray;
        searchElement = pSearchElement;
        start = pStart;
        end = pEnd;
        isReady = false;
    }


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

    public List<Integer> getIndexList()
    {
        Collection<Integer> lValues = resultMap.values();
        List<Integer> lResultList = new ArrayList<>(lValues);

        return lResultList;
    }

    public boolean isReady()
    {
        return isReady;
    }
//new Line
}
