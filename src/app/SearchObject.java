package app;

/**
 * SearchObject
 */
public class SearchObject {
    public int numberOfThreads = -1;
    public int numberOfIterations;

    public SearchObject(int numberOfIterations, int numberOfThreads) {
        this.numberOfIterations = numberOfIterations;
        this.numberOfThreads = numberOfThreads;
    }

    public SearchObject(int numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }
    
}