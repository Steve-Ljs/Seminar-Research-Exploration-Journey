package demo01_50;

public class Demo06
{
    /*
    动态规划
    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    dp[i][j]代表的是s的前i个字符与p的前j个字符是否匹配
    返回dp[M][N]
    if no * :dp[i][j]=dp[i-1][j-1] &&(p.charAt(j-1)=='.'||s.charAt(i-1)==p.charAt(j-1))
    if p.charAt(j-1)=='*' dp[i][j]=dp[i][j-2]||dp[i][j-1]||(dp[i-1][j]&&s.charAt(i-1)==p.charAt(j-1))

    初始化:dp[0][0]=1
     */
    public boolean isMatch(String s, String p)
    {
        int M = s.length(), N = p.length();
        boolean[][] dp = new boolean[M + 1][N + 1];

        dp[0][0] = true;
        for (int j = 1; j < N + 1; j++)//按照题意是不可能的,所以忽略了*开头的情况
        {
            if (p.charAt(j - 1) == '*' && j >= 2) dp[0][j] = dp[0][j - 2];
            else dp[0][j] = false;
        }
        for (int i = 1; i < M + 1; i++)
        {
            dp[i][0] = false;
        }

        for (int i = 1; i < M + 1; i++)
        {
            for (int j = 1; j < N + 1; j++)
            {
                /*这里需要注意:(p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2))
                因为假如是aa与a*,要对比的应该是p.charAt(j - 2)而本身p.charAt(j - 1),因为后者是*
                还有,如果是aa与.*,翻译过来应该是..  所以如果前者p.charAt(j - 2)是. 。也是能匹配的

                p.charAt(j - 1) == '*'的情况下，有三种情况：匹配0个，匹配1个，匹配多个，分别在下方的条件里
                 */
                //FBI warning if中
                if (p.charAt(j - 1) == '*' && j >= 2)//有*的话,j肯定是>=2的,不然忽略,因为本身就是错误的
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)));
                else
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args)
    {
        String s = "aa";
        String p = "a*";
        new Demo06().isMatch(s, p);
    }
}
