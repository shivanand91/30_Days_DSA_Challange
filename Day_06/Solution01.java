// 424. Longest Repeating Character Replacement

// You are given a string s and an integer k. You can choose any character of the string and change 
// it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing
//  the above operations.

// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.

class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowLength = right - left + 1;

            if(windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowLength = right - left + 1;
            maxWindow = Math.max(maxWindow, windowLength);
        }

        return maxWindow;
    }
}