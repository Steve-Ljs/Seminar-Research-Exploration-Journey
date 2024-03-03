```
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
```

```c++
class Solution 
{
//注意事项:stack存index所以是int类型;hi初始值为n,不能为top,因为可能s的最后是符合规范的;
//最后max(longest,hi),不是hi-lo,因为循环里面hi=lo了,而且最前面一个的话相当于是hi-0
public:
	/*
	从头到尾扫描字符串。如果当前字符是'（'，将其索引推送到堆栈。如果当前字符是'）'并且堆栈顶部索引处的字符是'（'，我们只是找到一个
	匹配的对，所以从堆栈弹出。否则，我们将'）' 的索引推送到堆栈。扫描完成后，堆栈将只包含无法匹配的字符索引。然后让我们使用相反的一侧 
	-相邻索引之间的子串应该是有效的括号。如果堆栈为空，则整个输入字符串有效。否则，我们可以扫描堆栈以获得最长的有效子字符串
	*/
	int longestValidParentheses(string s) 
	{
		int n = s.length(), longest = 0;
		stack<int> s_stack;
		for (int i = 0; i != n; ++i) 
		{
			if (s[i] == '(') s_stack.push(i);
			else 
			{
				if (!s_stack.empty()) 
				{
					if (s[s_stack.top()] == '(') s_stack.pop();
					else s_stack.push(i);
				}
				else s_stack.push(i);
			}
		}
		if (s_stack.empty()) longest = n;
		else 
		{
			int hi = n, lo = 0;
			while (!s_stack.empty()) 
			{
				lo = s_stack.top(); 
				s_stack.pop();
				longest = max(longest, hi - lo - 1);
				hi = lo;
			}
			longest = max(longest, hi);
		}
		return longest;
	}
};
```
