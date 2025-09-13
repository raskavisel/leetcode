import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Use a HashSet to store unique characters in the current window
        Set<Character> set = new HashSet<>();
        
        int left = 0; // left pointer of the window
        int maxLength = 0; // to keep track of the maximum length found

        // Move the right pointer to expand the window
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the set,
            // shrink the window from the left until it's removed
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(currentChar);

            // Update the maximum length of substring found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}