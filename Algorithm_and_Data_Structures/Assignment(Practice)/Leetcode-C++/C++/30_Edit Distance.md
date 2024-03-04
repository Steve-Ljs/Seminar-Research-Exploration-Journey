```
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

```c++
/*要应用DP，我们将状态定义为dp[i][j]要转换word1[0..i)为的最小操作数word2[0..j)。
对于基本情况，即将字符串转换为空字符串，最小操作数（删除）只是字符串的长度。所以我们有dp[i][0] = i和dp[0][j] = j。

对于一般情况下转换word1[0..i)到word2[0..j)，if word1[i - 1] == word2[j - 1]，则dp[i][j] = dp[i - 1][j - 1]。

如果word1[i - 1] != word2[j - 1]，我们需要考虑三个案例。

替换:替换word1[i - 1]为word2[j - 1]（dp[i][j] = dp[i - 1][j - 1] + 1）;
删除:如果word1[0..i - 1) = word2[0..j)那么delete word1[i - 1]（dp[i][j] = dp[i - 1][j] + 1）;
插入:如果word1[0..i) + word2[j - 1] = word2[0..j)然后插入 word2[j - 1]到word1[0..i)（dp[i][j] = dp[i][j - 1] + 1）。
所以，何时word1[i - 1] != word2[j - 1]，dp[i][j]只是上述三种情况中的最小值。*/
class Solution 
{
public:
	int minDistance(string word1, string word2) 
	{
		int m = word1.size(), n = word2.size();
		vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
		for (int i = 1; i <= m; ++i) 
			dp[i][0] = i;
		for (int j = 1; j <= n; j++) 
			dp[0][j] = j;
		for (int i = 1; i <= m; ++i) 
			for (int j = 1; j <= n; ++j) 
				if (word1[i - 1] == word2[j - 1]) 
					dp[i][j] = dp[i - 1][j - 1];
				else 
					dp[i][j] = min(dp[i - 1][j - 1], min(dp[i][j - 1], dp[i - 1][j])) + 1;
		return dp[m][n];
	}
};
```

```c++
//和上一个差不多,但是只用了一个向量,节省内存
//每次当我们更新时间dp[i][j]，我们只需要dp[i - 1][j - 1]，dp[i][j - 1]和dp[i - 1][j]。我们可以优化代码的空间,甚至只是一个向量
class Solution 
{
public:
	int minDistance(string word1, string word2) 
	{
		int m = word1.size(), n = word2.size(), pre;
		vector<int> dp(n + 1, 0);//只用word2的
		for (int j = 1; j <= n; ++j) 
			dp[j] = j;
		for (int i = 1; i <= m; ++i) 
		{
			pre = dp[0];//第一次替换为相等所需要的操作数
			dp[0] = i;//现在的pre存了dp[i][0];
			for (int j = 1; j <= n; ++j) 
			{
				int temp = dp[j];//temp存了dp[i-1][j-1]
				if (word1[i - 1] == word2[j - 1]) 
					dp[j] = pre;
				else 
					dp[j] = min(pre, min(dp[j - 1], dp[j])) + 1;//此时min里面的dp[j]没变,所以相当于取上,左,左上的最小值 再加1
				pre = temp;
			}
		}
		return dp[n];
	}
};
```
