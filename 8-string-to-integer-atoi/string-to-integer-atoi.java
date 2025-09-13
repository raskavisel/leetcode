class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        int n = s.length();
        
        // 1. Skip all leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        // 2. Check for sign indicator '+' or '-'
        if (index < n) {
            if (s.charAt(index) == '+') {
                sign = 1;
                index++;
            } else if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            }
        }
        
        // 3. Convert the following digits into a number
        while (index < n) {
            char ch = s.charAt(index);
            
            // If current char is not a digit, stop reading further
            if (ch < '0' || ch > '9') {
                break;
            }
            
            int digit = ch - '0';
            
            // 4. Check for overflow before adding digit
            // If total > (MAX - digit) / 10, adding digit will cause overflow
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                // Clamp result to Integer.MAX_VALUE or Integer.MIN_VALUE based on sign
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            total = total * 10 + digit;
            index++;
        }
        
        // Apply the sign and return the final number
        return total * sign;
    }
}
