package niuke;

public class JZ52 {
    /*
   动态规划
   dp[i][j] 代表str[0,i-1]与pattern[0,j - 1]匹配

   初始化:
   dp[0][0] = 1
   dp[i][0] = 0 i >= 1
   dp[0][j] = 0 如果pattern[j - 1]为*,那么可以匹配0次,dp[0][j] = dp[0][j - 2] 注意合法校验

   递推公式:
   if (pattern[j - 1]=='*') {
       //*可以匹配0个，匹配1个，匹配多个
       dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || (dp[i - 1][j] && (pattern[j - 2]=='.' || pattern[j - 2] == str[i - 1]))

   }
   else {
       dp[i][j] = (pattern[j - 1]=='.' || pattern[j - 1] == str[i - 1])
   }

   返回值:dp[m][n]


   */
    public boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        int m = dp.length, n = dp[0].length;

        //必须放最前面，因为后面依赖到了
        dp[0][0] = true;
        for (int i = 1; i < m; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < n; j++) {
            if (j >= 2 && pattern[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            } else {
                dp[0][j] = false;
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j >= 2 && pattern[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || (dp[i - 1][j] && (pattern[j - 2] == '.' || pattern[j - 2] == str[i - 1]));
                } else if (pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }


        return dp[m - 1][n - 1];
    }
}
