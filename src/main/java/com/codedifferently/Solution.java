package com.codedifferently;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Solution {

    /**
     * You will be given an array of numbers, search the array and return the longest
     * set of consecutive numbers
     * example input - {1,3,2,10,6,5,7,8}
     * return the String "Longest Set: {5 6 7 8}"
     * Even though 1,2,3 would the first consecutive set 5,6,7,8 is longer
     *
     * @param allNumbers
     * @return First sort the array
     * Loop through the array
     * in the for loop check if its consecutive
     * placeholder , empty array ?
     */
    //{1,2,3,5,6,7,8,10};
    public String findLongestConsecutiveSet(Integer[] allNumbers) {
        Arrays.sort(allNumbers);
        List<Integer> tempList = new ArrayList<>(); // prepare temp list for later use
        List<List<Integer>> arrays = new ArrayList<>(); // used to store the sequences
        int lastNum = allNumbers[0]; // get the fist number for comparison in loop
        tempList.add(lastNum);
        for (int i = 1; i < allNumbers.length; i++) {
            if (allNumbers[i] - 1 == lastNum) { // check for sequence (e.g fist num was 12,
                // current number is 13, so 13-1 = 12,
                // so it has the sequence), then store the number
                tempList.add(allNumbers[i]); // store it to the temp list
                lastNum = allNumbers[i]; // keep current number for the next
            } else { // if it has not the sequence, start the new sequence
                arrays.add(tempList); // fist store the last sequence
                tempList = new ArrayList(); // clear for the next sequence
                lastNum = allNumbers[i]; // init the lastNumnber
                tempList.add(lastNum);
            }
        }
// now iterate for the longest array
// craete an empty array to store the longest
        List<Integer> longestLength = new ArrayList<>();
        for (List<Integer> arr : arrays) {
            if (arr.size() > longestLength.size()) {
                // check if the current array hase the longest size than the last one
                // if yes, update the last one
                longestLength = arr;

            }
        }
// at the end print the result.
        return "Longest Set: " + longestLength.toString().replaceAll("\\[", "{").replaceAll("\\]","}").replaceAll(",", "");
    }

}
