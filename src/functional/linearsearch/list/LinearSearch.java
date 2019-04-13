package functional.linearsearch.list;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import app.Testable;

public class LinearSearch extends Testable {
    private static LinearSearchInterface linearSearch = (arr, str) -> {
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

    static BiFunction<int[], Integer, List> findFunctional = (arr, searchInt) -> {
        return linearSearch.search(arr, (int) searchInt);
    };
}