```
Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 
Note:
The input string length won't exceed 1000.
```

```c++
class Solution 
{
public:
	int countSubstrings(string s) 
	{
		int result = 0, n = s.length();
		//对于每一个先以135看是否可以，再以2,4,6看，向左边兼容
		for (int i = 0; i < n; ++i) 
		{
			for (int j = 0; i - j >= 0 && i + j < n && s[i - j] == s[i + j]; ++j)
			{
				++result; //substring s[i-j, ..., i+j]
			}
			for (int j = 0; i - 1 - j >= 0 && i + j < n && s[i - 1 - j] == s[i + j]; ++j) 
			{
				++result; //substring s[i-1-j, ..., i+j]
			}
		}
		return result;
	}
};
```
