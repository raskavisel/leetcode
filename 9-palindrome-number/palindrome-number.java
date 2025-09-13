class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (because of the '-' sign).
        if (x < 0) return false;

        // If the last digit is 0, the number must be 0 to be a palindrome (e.g., 10 is not).
        if (x % 10 == 0 && x != 0) return false;

        int revertedHalf = 0;
        // Build the reversed number for the last half of digits
        while (x > revertedHalf) {
            int digit = x % 10;            // take last digit
            revertedHalf = revertedHalf * 10 + digit; // append it to revertedHalf
            x /= 10;                       // remove last digit from x
        }

        // For even length: x == revertedHalf.
        // For odd length: remove the middle digit from revertedHalf by revertedHalf/10, then compare.
        return x == revertedHalf || x == revertedHalf / 10;
    }
}