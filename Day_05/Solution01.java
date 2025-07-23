// Permutation in String

// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Example 2:
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Count = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(s1Count.equals(s2Count)){
            return true;
        }

        int left = 0;

        for(int right = s1.length(); right < s2.length(); right++){
            char charRight = s2.charAt(right);
            s2Count.put(charRight, s2Count.getOrDefault(charRight, 0) + 1);

            char charLeft = s2.charAt(left);
            s2Count.put(charLeft, s2Count.get(charLeft) - 1);

            if(s2Count.get(charLeft) == 0){
                s2Count.remove(charLeft);
            }

            left++;

            if(s1Count.equals(s2Count)){
                return true;
            }
        }

        return false;
    }
}