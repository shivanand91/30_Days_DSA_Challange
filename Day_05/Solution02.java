// Palindrome Partitioning

// Given a string s, partition s such that every substring of the partition is a palindrome. 
// Return all possible palindrome partitioning of s.

// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

// Example 2:
// Input: s = "a"
// Output: [["a"]]
 
import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) &&
                        (length == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;

    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));

                backtrack(s, end + 1, path, result, dp);

                path.remove(path.size() - 1);
            }
        }
    }
}