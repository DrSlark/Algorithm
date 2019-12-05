class Solution5 {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        boolean[][] m = new boolean[s.length()][s.length()];
        int maxi = 0;
        int maxj = 0;
        for (int j = 0; j < s.length(); j++) {
            m[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (m[i + 1][j - 1] || j - i <= 1)) {
                    m[i][j] = true;
                }
                if (m[i][j] && j - i > maxj - maxi) {
                    maxj = j;
                    maxi = i;
                }
            }
        }
        return s.substring(maxi, maxj + 1);

    }
}