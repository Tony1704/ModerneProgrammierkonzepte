package oo.binarysearch;

import app.SearchObject;
import app.TestFunctionality;

import java.util.function.BiFunction;

/**
 * Binarysearch
 */
public class OOBinarySearch extends TestFunctionality {
    private static int[] numbers;

    /**
     * Constructor Method for BinarySearch
     * @param numbersArray numbersArray must be a sorted array!
     */
    OOBinarySearch(int[] numbersArray){
        numbers = numbersArray;
    }

    /**
     * Searches for the given number in the array. If it's not inside the array, return value wil be -1.
     * @param searchedNumber
     * @return index of the searched number in the array
     */
    static int searchNumber(int searchedNumber){
        return searchNumberRekursiv(searchedNumber, 0,numbers.length-1);
    }

    private static int searchNumberRekursiv(int searchedNumber, int fromIndex, int toIndex){
        int middle = ((toIndex- fromIndex)/2) + fromIndex;
        if(fromIndex > toIndex){
            return -1;
        }
        if(numbers[middle]>searchedNumber){
            return searchNumberRekursiv(searchedNumber,fromIndex,middle-1);
        }else if(numbers[middle]<searchedNumber){
            return searchNumberRekursiv(searchedNumber,middle+1,toIndex);
        }else if(numbers[middle]==searchedNumber)return middle;
        else return -2;
    }

    public static BiFunction<int[], SearchObject, Integer> binarysearchTest = (arr, searchObject) -> {
        OOBinarySearch lOOBinarySearch = new OOBinarySearch(arr);
        searchNumber(searchObject.search);
        return -1;
    };
}