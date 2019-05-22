# ModerneProgrammierkonzepte
Project by Marcel Mertens, Anton Ochel, Tizian Groß, Tristan Emig & Benno Grimm

## General Idea
* Create a Program that sorts a given Array using Quicksort and then searches for a given Element using Binary Search. 
* Compare that to a Program that searches the Array in a linear matter.
* Find out for which of those programs is more useful for different search operations.

## Concept
* A UI displays all the test results of the different algorithms
* 4 search algorithms and 2 sort & search algorithms can be compared
  * each of the algorithms returns a minimum time, a maximum time and an average time
* every algorithm is tested
  * the test consist of a 10000 element array where one random specific number has to be found
    * it is repeated 100 times to get the test results
    
## Structure
* Every category has its own package
* Every algorithm is its own class
* The UI starts every class with a test function that is implementet through an abstract class
* The results are then displayed

## Developement

### What we found out
* Not every search algorithm can be implemented in a functional way
  * For some, it does not even make sense -> recursive algorithms
* Multithreaded programming produces a lot of unecessary overhead

### Problems and fixes
* In an earlier version, the first results were higher than the results after restarting the tests (while the application is still open)
  * This was due to the cache memory and page tables that adjust over time to the running processes
    * This was fixed by running through the test 6 times before showing the first test results -> this results in a longer loading time at first
  
## Explaining the results

### Searching by Index vs. Searching by List
When comparing all the algorithms by their output logic, it is easy to see that in almost all cases, the index search is faster; up to 2 times.
This makes sense when you look at the structure of the algorithm. When you only search for the index, the search process is stopped after the first matched result is found. With the list, every matched result is being extracted from the array, subsequently, the whole array is being run through. This also explains their min and max times being closer together in some cases. Furthermore, the list functions have to manage a seperate list, which slows them down even more.

### Functional vs. Multithreaded vs. Object Oriented
When comparing all the algorithms by their internal logic, the results are unanimous: object oriented is the fastest, functional takes the second place and multithreaded is the lowest by a big margin.
This can be explained. The object oriented functions have direct acceess to the array, which greatly reduces their time to get a number to compare it, while the functional functions have to work with the stream. The multithreaded functions are by far the slowest because their massive overhead and management impairs their performance.

### Linear Search vs. Quick Sort + Binary Search
Now, when we look at our main objective of this project, we can see that the QuickSort + BinarySearch method is performing way better than all the other options. Especially binary search is incredibly fast, outperforming any other search algorithm by at least 2 times. This result, of course, is only representative to the specific parameters applied here. Changing the number of searched numbers and the size of the array will change the results drastically and may give a different algorithm the best performance.  

----
©Multiflex KG
