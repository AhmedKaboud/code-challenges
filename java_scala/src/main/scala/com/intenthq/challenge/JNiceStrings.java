package com.intenthq.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JNiceStrings {
  // From http://adventofcode.com/day/5
  //  --- Day 5: Doesn't He Have Intern-Elves For This? ---
  //
  //  Santa needs help figuring out which strings in his text file are naughty or nice.
  //
  //    A nice string is one with all of the following properties:
  //
  //    It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
  //  It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
  //    It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
  //    For example:
  //
  //    ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
  //  aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
  //    jchzalrnumimnmhp is naughty because it has no double letter.
  //    haegwjzuvuyypxyu is naughty because it contains the string xy.
  //    dvszwmarrgswjxmb is naughty because it contains only one vowel.
  //    How many strings are nice?

  public static boolean isNice(String str) {
    Set<Character> vowelsCharacters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    Set<String> restrictedPairs = new HashSet<>(Arrays.asList("ab", "cd", "pq", "xy"));
    boolean doubledCharacter = false;
    int numberOfVowels = 0;

    char previousCharacter = '\0';
    for(char currentCharacter : str.toCharArray()) {
      // Count the number of vowels
      if(vowelsCharacters.contains(currentCharacter)) {
        numberOfVowels++;
      }

      // Validate the doubled chars in row
      if(previousCharacter == currentCharacter) {
        doubledCharacter = true;
      }

      // Check the restricted the doubled char in row
      if(restrictedPairs.contains("" + previousCharacter + currentCharacter)) {
        return false;
      }

      previousCharacter = currentCharacter;
    }

    return doubledCharacter && numberOfVowels >= 3;
  }

  public static int nice(List<String> xs) {
    int countOfNiceStrings = 0;
    for(String str : xs) {
      if(isNice(str)) {
        countOfNiceStrings++;
      }
    }

    return countOfNiceStrings;
  }

}