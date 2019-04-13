package functional.linearsearch.index;

import java.util.stream.IntStream;
import app.Testable;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class FunctionalLinearSearchIndex extends Testable {
    private static FunctionalLinearSearchIndexInterface linearSearch = (intArr, intSearch) -> {
        try {
            return IntStream
                    .range(0, intArr.length)
                    .filter(i -> intArr[i] == intSearch)
                    .findFirst()
                    .getAsInt();
        } catch (NoSuchElementException e) {
            return -1;
        }
    };


    public static int findLin(int[] arr, int searchInt) {
        return linearSearch.search(arr, searchInt);
    }

    public static BiFunction<int[], Integer, Integer> findTest = (arr, searchInt) -> {
        return linearSearch.search(arr, (int) searchInt);
    };

}