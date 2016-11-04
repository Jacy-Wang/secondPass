public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] len = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    len[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (j == 0) {
                    len[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '1')
                        len[i][j] = Math.min(Math.min(len[i - 1][j], len[i][j - 1]), len[i - 1][j - 1]) + 1;
                    else
                        len[i][j] = 0;
                }
                maxLen = Math.max(maxLen, len[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}
