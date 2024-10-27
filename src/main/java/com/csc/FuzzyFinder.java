package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {

  //linear search algorithm
  public int linearSearch(ArrayList<Fuzzy> fuzzies, String fuzzyToFind) {
    for (int i = 0; i < fuzzies.size(); i++) {
      if (fuzzies.get(i).color.equals(fuzzyToFind)) {
        return i;
      }
    }
    return -1;
  }

  //binary search algorithm
  public int binarySearch(ArrayList<Fuzzy> fuzzies, String fuzzyToFind) {
    int low = 0;
    int high = fuzzies.size() - 1;

    while (low <= high) {
      int middlePosition = (low + high) / 2;
      Fuzzy middleFuzzy = fuzzies.get(middlePosition);

      int compare = fuzzyToFind.compareTo(middleFuzzy.color);

      if (compare == 0) {   //compareTo returns 0 if equal; string is found in middle position
        return middlePosition;
      }
      if (compare < 0) {    //compareTo returns value <0 if string is less than what it's compared to; string is before middle position
        high = middlePosition - 1;
      }
      else {     //string is after middle position
        low = middlePosition + 1;
      }
    }
    return -1;
  }

  public static void main(String args[]) {
    FuzzyListGenerator generator = new FuzzyListGenerator();
    FuzzyFinder finder = new FuzzyFinder();
    
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

    //manually test search algorithms
    int testOne = finder.linearSearch(sortedFuzzies, "gold");
    int testTwo = finder.linearSearch(randomFuzzies, "gold");
    int testThree = finder.binarySearch(sortedFuzzies, "gold");
    int testFour = finder.binarySearch(randomFuzzies, "gold");

    //output results
    System.out.println("Linear Search for Sorted Fuzzies: " + testOne);
    System.out.println("Linear Search for Random Fuzzies: " + testTwo);
    System.out.println("Binary Search for Sorted Fuzzies: " + testThree);
    System.out.println("Binary Search for Random Fuzzies: " + testFour);
  }
}
