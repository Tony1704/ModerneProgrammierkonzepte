package functional.linearsearch.list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinearSearchList {
    private static LinearSearchInterfaceList linearSearch = (arr, str) -> {
        List list = IntStream
                .range(0, arr.length)
                .filter(i -> arr[i] == str)
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        return list;
    };

    public static List searchint(int [] arr, int searchInt){
        return linearSearch.search(arr, searchInt);
    }
}
