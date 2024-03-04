package hot;

import java.util.List;

public class Demo139
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        if(s==null || s.length()==0) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && wordDict.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                    //look 找到一个即可,不用继续找了
                }
            }
        }
        return dp[s.length()];
    }
}
