package app;

/**
 * SearchObject
 */
public class SearchObject {
    public int numberOfThreads = -1;
    public int search;

    /**
     * Creates a SearchObject that can be passed to a BiFunction to run tests 
     * @param search int containing the search Integer used for testing search Algorithms
     * @param numberOfThreads
     */
    public SearchObject(int search, int numberOfThreads) {
        this.search = search;
        this.numberOfThreads = numberOfThreads;
    }
    
}