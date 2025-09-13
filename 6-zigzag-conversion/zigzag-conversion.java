public class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1, return the string as is
        if (numRows == 1) {
            return s;
        }

        // Initialize a StringBuilder array to hold rows
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string and place characters in the appropriate rows
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows to get the final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
