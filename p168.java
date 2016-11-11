public class Solution {
    public String convertToTitle(int n) {
        int q = n;
        int r;
        StringBuilder sb = new StringBuilder();
        while (q > 26) {
            r = q % 26;
            q /= 26;
            if (r == 0) {
                sb.append('Z');
                q -= 1;
            } else {
                sb.append((char) ('A' + r - 1));
            }
        }
        System.out.println(q);
        sb.append((char) ('A' + q - 1));
        return sb.reverse().toString();
    }
}
