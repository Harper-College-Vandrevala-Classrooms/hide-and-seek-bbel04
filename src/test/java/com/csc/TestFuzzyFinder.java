package com.csc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }

  @Test
  void linearSearchOfSortedFuzzies() {
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    int result = finder.linearSearch(sortedFuzzies, "yellow");
    assertTrue(result >= 6000 && result <= 6999, "Expected: " + result);  //each color has iterations of 1000, Yellow is 6th color, so it should be found within 6000-6999
  }

  @Test
  void binarySearchOfSortedFuzzies() {
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    int result = finder.binarySearch(sortedFuzzies, "yellow");
    assertTrue(result >= 6000 && result <= 6999, "Expected: " + result); 
  }
}
