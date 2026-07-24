
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentValue = board[i][j];
                if (currentValue != '.') {
                    // For each value, ensure it is unique in its row, column, and sub-grid
                    if (!seen.add(currentValue + " found in row " + i) ||
                        !seen.add(currentValue + " found in column " + j) ||
                        !seen.add(currentValue + " found in subgrid " + i/3 + "-" + j/3)) {
                        return false;  // If any of the adds return false, the board isn't valid
                    }
                }
            }
        }
        return true;
    }
}