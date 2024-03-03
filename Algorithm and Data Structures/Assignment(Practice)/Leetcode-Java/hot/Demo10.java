package hot;

public class Demo10
{
    public boolean isMatch(String s, String p)
    {
        //look如果判断s.length()==0,会很难处理 因为""与".*"是匹配的
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        //初始化 不需要判断s,p的长度是否0,因为dp[0][0]肯定存在
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) dp[i][0] = false;
        //默认*不能出现在最前面
        for (int j = 1; j <= n; j++)
        {
            if (p.charAt(j - 1) == '*' && j >= 2) dp[0][j] = dp[0][j - 2];
            else dp[0][j] = false;
        }

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                char charS = s.charAt(i - 1);
                char charP = p.charAt(j - 1);

                if (charS == charP || charP == '.')
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (charP == '*' && j >= 2)
                {
                    //look,匹配多个判断,首先要s[0,i-2]的都匹配了(即dp[i-1][j]匹配),再看s[i-1]是否能匹配上p中要复制的字符
                    //即p.charAt(j - 2)和它相等或者为.的情况(.*)
                    boolean matchMore = (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == charS));
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || matchMore;
                }
            }
        }

        return dp[m][n];
    }
}
