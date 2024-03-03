```
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
```

```c++
class Solution
{
public:
	bool isValid(string s) 
	{
		stack<char> paren;
		for (int i = 0; i != s.size(); ++i)
		{
			if (s[i] == '(' || s[i] == '[' || s[i] == '{')
				paren.push(s[i]);
			if (s[i] == ')')
				if (paren.empty() || paren.top() != '(')
					return false;
				else
					paren.pop();
			if (s[i] == ']')
				if (paren.empty() || paren.top() != '[')
					return false;
				else
					paren.pop();
			if (s[i] == '}')
				if (paren.empty() || paren.top() != '{')
					return false;
				else
					paren.pop();
		}
		if (paren.empty())
			return true;
		else
			return false;
	}
};
```
