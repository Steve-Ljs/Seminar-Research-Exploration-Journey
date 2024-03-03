```
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```c++
class Solution 
{
//精美绝伦
public:
	vector<string> generateParenthesis(int n) 
	{
		vector<vector<string>> f(n + 1);
		f[0] = { "" };//只含有0对括号的解法
		for (int i = 1; i <= n; ++i) //一到多对
			for (int j = 0; j != i; ++j) 
				for (const string &s1 : f[j]) //前面混合的情况
					for (const string &s2 : f[i - j - 1]) 
						f[i].push_back("(" + s1 + ")" + s2);
		return f[n];//最终的vec
	}
};
```
