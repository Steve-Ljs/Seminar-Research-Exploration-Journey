```
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
```

```c++
//挺难的一题,不过解法可以作为一个模板
class Solution 
{
public:
	string minWindow(string s, string t) 
	{
		vector<int> vec(64, 0);//存int不是存char
		for (auto c : t) 
			vec[c-'A']++;
		int counter = t.size(), begin = 0, end = 0;
		int sub_length = INT_MAX, head = 0;//目标字符串初始化为无穷大
		while (end < s.size()) 
		{
			if (vec[s[end++]-'A']-- > 0) --counter; //该字符在t里面
			//把经过s的其他字符变为负数,t拥有的变为0,或者负数
			while (counter == 0) //说明已经找到包含全部t的
			{ 
				if (end - begin < sub_length)//取较小长度的
				{
					head = begin;
					sub_length = end -  begin;
				}
				if (vec[s[begin++]-'A']++ == 0) ++counter;  
				//如果碰到了t中的必须的字符(为0)则跳出循环,且该必须元素变为1,即下一次找到该必须元素就会继续判断是否是最短
				//如果没跳出循环,则之前的begin是负数,是不需要的元素,这样缩短了最小长度
			}
		}
		return sub_length == INT_MAX ? "" : s.substr(head, sub_length);
	}
};
```
