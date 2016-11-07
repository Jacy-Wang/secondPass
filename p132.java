public class Solution {
    public int minCut(String s) {
        boolean[][] pal = new boolean[s.length()][s.length()];
        isPalindrome(s, pal);
        int[] minVal = new int[s.length() + 1];
        minVal[0] = -1;
        for (int i = 1; i < s.length() + 1; i++) {
            minVal[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (pal[j][i - 1]) {
                    minVal[i] = Math.min(minVal[i], minVal[j] + 1);
                }
            }
        }
        return s.length() == 0 ? 0 : minVal[s.length()];
    }

    public void isPalindrome(String s, boolean[][] pal) {
        for (int i = 0; i < pal.length; i++) {
            pal[i][i] = true;
            if (i < pal.length - 1) {
                pal[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            }
        }
        for (int i = pal.length - 2; i >= 0; i--) {
            for (int j = i + 2; j < pal[i].length; j++) {
                pal[i][j] = (pal[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
            }
        }
    }
}
