```
给定非空字符串s和包含非空字列表的字典wordDict，确定s是否可以被分段为一个或多个字典单词的空格分隔序列。
注意：
字典中的相同单词可以在分段中多次重复使用。
您可能认为字典不包含重复的单词
Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
             
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
```

```c++
class Solution 
{
public:
	bool wordBreak(string s, vector<string>& wordDict) 
	{
		vector<bool>dp(s.size() + 1, 0);
		dp[0] = true;//相当于从0切分一次是允许的
		//假设s为leetcode,对于s的每个字符例如c,如果切分成功过leet,那么尝试切分c,和leetc
		for (int i = 1; i <= s.size(); ++i) 
		{
			for (int j = i - 1; j >= 0; --j) //从i-1到0开始找的好处是更短的字符一般能更快的找到,速度更快
			{
				if (dp[j]) 
				{
					string substring = s.substr(j, i - j);
					if (find(wordDict.begin(), wordDict.end(), substring) != wordDict.end()) 
					{
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[s.size()];
	}
};
```
