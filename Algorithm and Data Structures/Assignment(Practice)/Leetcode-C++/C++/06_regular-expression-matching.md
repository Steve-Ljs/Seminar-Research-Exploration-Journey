```
给定输入字符串（s）和模式（p），实现与支持'.'和的正则表达式匹配'*'。

'' 匹配任何单个字符。
'*'匹配前面元素的零个或多个。
匹配应覆盖整个输入字符串（不是部分）。

注意：

s 可能是空的，只包含小写字母a-z。
p可能是空的，只包含小写字母a-z和字符，如  . 或  *。
例1：

输入：
s =“aa”
p =“a”
输出： false
 说明： “a”与整个字符串“aa”不匹配。
例2：

输入：
s =“aa”
p =“a *”
输出： true
 说明：  '*'表示零个或多个前面元素'a'。因此，通过重复“a”一次，它变为“aa”。
例3：

输入：
s =“ab”
p =“。*”
输出： true
 说明：  “。*”表示“零或多个（*）任何字符（。）”。
例4：

输入：
s =“aab”
p =“c * a * b”
输出： true
 说明：  c可重复0次，a可重复1次。因此它匹配“aab”。
例5：

输入：
s =“mississippi”
p =“mis * is * p *。”
输出： false
```
```c++
//自己的实现用了很多条件判断,还没有成功
class Solution 
{
public:
	bool isMatch(string s, string p) 
	{
		int m = s.size(), n = p.size();
		vector<vector<bool>> f(m + 1, vector<bool>(n + 1, false));
		//bool二维数组,默认为false,(i+1)*(j+1),
		//f[m][n]的含义是s[0-m] 与 s[0-n]是否匹配
		
		/*  p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1] 
			这次匹配的和上次各少一个字符的一样
			If p.charAt(j) == ‘.’ : dp[i][j] = dp[i-1][j-1];

			如果*，我们就看哪种情况有真值可以传递，就继续传递下去。
			If p.charAt(j) == ‘*’: 
			here are two sub conditions: 
			if p.charAt(j-1) != s.charAt(i) : 
				dp[i][j] = dp[i][j-2] //相当于*取值为0,跳过前面一个字符
			if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == ‘.’: //如果前面这个字符与s下一个字符匹配
				dp[i][j] = dp[i-1][j] //传递了n次
				dp[i][j] = dp[i][j-1] // 传递了1次
				dp[i][j] = dp[i][j-2] // 传递了0次
		*/
		//f[0][0]=true表示如果p为空串的话,一定能匹配空串s
		f[0][0] = true;
		//如果p为空,s不为空,肯定匹配不了
		for (int i = 1; i <= m; i++)
			f[i][0] = false;
		//初始化第0列，只有X*能匹配空串，如果有*，它的真值一定和p[0][j-2]的相同（略过它之前的符号）
		//j如果等于1,就不能是*,就一定匹配不成功p[j-1]其实就代表第j个元素
		for (int j = 1; j <= n; j++)
			f[0][j] = j > 1 && '*' == p[j - 1] && f[0][j - 2];

		//长度为1-m,1-n时
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				if (p[j - 1] != '*')//p[j-1]是第j个元素
					//只有当前字符完全匹配，才有资格传递dp[i-1][j-1] 真值
					f[i][j] = f[i - 1][j - 1] && (s[i - 1] == p[j - 1] || '.' == p[j - 1]);
				else
					//f[i][j-2]只能说明*不会开头,不然就越界了
					//如果*忽略了该字符为true,则传递true    或者*前的与s的那个字符相等,传1次或者多次
					//相当于所有的可以传下去的尽量传
					f[i][j] = f[i][j - 2]|| f[i][j-1] || ((s[i - 1] == p[j - 2] || '.' == p[j - 2]) && f[i - 1][j]);

		return f[m][n];
		
	}
};
```
