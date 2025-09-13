public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Sets to track numbers already seen in rows, columns, and sub-boxes
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                
                if (num != '.') {
                    // Row, Column, and Sub-box checks
                    String rowKey = "row" + i + "-" + num;
                    String colKey = "col" + j + "-" + num;
                    String boxKey = "box" + (i / 3) + "-" + (j / 3) + "-" + num;
                    
                    // If any of the keys have been seen, return false
                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                        return false;
                    }
                    
                    // Add the current number to the respective sets
                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(boxKey);
                }
            }
        }
        
        return true;
    }
}
