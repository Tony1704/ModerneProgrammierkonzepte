package app;

/**
 * SearchObject
 */
public class SearchObject {
    public int numberOfThreads = -1;
    public int search;

    /**
     * Creates a SearchObject that can be passed to a BiFunction to run tests 
     * @param search int containing the search integer used for testing search algorithms
     * @param numberOfThreads number of threads being used for testing
     */
    public SearchObject(int search, int numberOfThreads) {
        this.search = search;
        this.numberOfThreads = numberOfThreads;
    }

}