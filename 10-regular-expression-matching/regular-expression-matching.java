class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // Step 1: Create DP table
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Step 2: Empty string and empty pattern match
        dp[0][0] = true;
        
        // Step 3: Fill for patterns like a*, a*b*, a*b*c* at the start
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Step 4: Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                char sc = s.charAt(i - 1); // current char in s
                char pc = p.charAt(j - 1); // current char in p
                
                // Case 1: If characters match OR pattern has '.'
                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                
                // Case 2: If pattern char is '*'
                else if (pc == '*') {
                    // Zero occurrence of previous char
                    dp[i][j] = dp[i][j - 2];
                    
                    // One or more occurrence (check if previous char matches)
                    char prev = p.charAt(j - 2);
                    if (prev == sc || prev == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        // Step 5: Answer is dp[m][n]
        return dp[m][n];
    }
}