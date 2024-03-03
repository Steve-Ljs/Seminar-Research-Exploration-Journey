package demo01_50;

import java.util.List;

public class Demo49_look
{
    /*
    动态规划,dp[i]代表s.substring(0,i)能否被表示
    dp[0]=true
    return dp[s.length()]
    dp[i]=for(word in wordDict) if(word.length()<i && s.contain(word) && dp[i-word.length]==true)
     */
    //下面是不行的,例如acdb, wordDict[acd,a],那么也能过,但是这逻辑错误了
    /*for (String word : wordDict)
    {
        int m = word.length();
        if(m<=i && s.substring(0,i).contains(word) && dp[i-word.length()])
        {
            dp[i] = true;
            break;
        }
    }*/
    public boolean wordBreak(String s, List<String> wordDict)
    {
        if (s == null || s.length() == 0) return false;//因为s非空,所以如果为空,输入错误,返回false
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;//因为恰好是时,会看dp[0]==true否,那肯定的啊
        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && wordDict.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;//FBI warning有就行了,不必继续寻找其他的了
                }
            }
        }
        return dp[n];
    }
}
