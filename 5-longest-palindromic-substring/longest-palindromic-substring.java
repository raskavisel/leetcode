public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0; // Start index of the longest palindrome
        int end = 0;   // End index of the longest palindrome

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (center is one character)
            int len1 = expandAroundCenter(s, i, i);
            // Case 2: Even length palindrome (center is between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the maximum length from both cases
            int len = Math.max(len1, len2);

            // Update start and end if we found a longer palindrome
            if (len > end - start) {
                // Update start and end based on the new palindrome length
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindrome substring
        return s.substring(start, end + 1);
    }

    // Helper method to expand around the center and return the length of palindrome
    private int expandAroundCenter(String s, int left, int right) {
        // Expand while characters match and indices are in bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;   // Move left pointer left
            right++;  // Move right pointer right
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}
