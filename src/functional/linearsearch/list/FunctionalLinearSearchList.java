package functional.linearsearch.list;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import app.Testable;

public class FunctionalLinearSearchList extends Testable {

    private static FunctionalLinearSearchListInterface linearSearch = (arr, str) -> {
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

    public static BiFunction<int[], Integer, List> findFunctional = (arr, searchInt) -> {
        return linearSearch.search(arr, (int) searchInt);
    };

}
