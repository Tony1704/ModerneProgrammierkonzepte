package app;

/**
 * SearchObject
 */
public class SearchObject {
    public int numberOfThreads = -1;
    public int search;

    public SearchObject(int search, int numberOfThreads) {
        this.search = search;
        this.numberOfThreads = numberOfThreads;
    }
    
}