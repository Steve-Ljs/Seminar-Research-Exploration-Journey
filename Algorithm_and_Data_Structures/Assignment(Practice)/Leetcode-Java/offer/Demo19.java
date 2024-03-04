package offer;

public class Demo19 {
    /*
    动态规划
    dp[i][j] 代表 s[0,i - 1]与p[0,j - 1]匹配

    初始化:
    dp[0][0] = true
    如果是 * ,dp[0][j] = dp[0][j-2], 否则dp[0][j] = 0
    dp[i][0] = 0

    递推公式:
    if(p.charAt(j-1) == '*') {
        //匹配0个 匹配1个 匹配多个
        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));


    }
    else if(p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
    else dp[i][j] = false;
    */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < n + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                if (j == 1) {
                    throw new RuntimeException("Illegal Argument");
                }
                dp[0][j] = dp[0][j - 2];
            }
            else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (j == 1) {
                        throw new RuntimeException("Illegal Argument");
                    }
                    //匹配0个 匹配1个 匹配多个
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                }
                else if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}
