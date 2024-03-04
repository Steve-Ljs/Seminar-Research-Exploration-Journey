```
给定一个编码字符串，返回它的解码字符串。

编码规则是：k[encoded_string]，其中方括号内的encoded_string正在重复k次。注意，k保证是正整数。

您可以假设输入字符串始终有效; 没有多余的空白区域，方括号格式正确等。

此外，您可以假设原始数据不包含任何数字，并且该数字仅用于那些重复数字k。例如，不会有像3a或那样的输入2[4]。

例子：

s =“3 [a] 2 [bc]”，返回“aaabcbc”。
s =“3 [a2 [c]]”，返回“accaccacc”。
s =“2 [abc] 3 [cd] ef”，返回“abcabccdcdcdef”。
```

```c++
/*
1.使用两个栈，countStack存子串的重复次数，resStack存中间结果
2.读取完一个数字，把数量入countStack栈
3.读取到[时，把n[前面的结果计算出来并入resStack栈
4.读取到]时，取出最近一次n[res]前面的中间计算结果，也就是resStack的栈顶，再append n次res，n为countStack的栈顶，res为最近一次[]中间的子串
5.其他情况，将字符追加到res末尾

比如:  3[a]2[b3[d]c]
下面是读完各字符时的情况：
*        读完:  3    [     a     ]     2    [    b      3       [      d       ]      c       ]
* countStack: (3)  (3)   (3)    ()   (2)  (2)  (2)   (2 3)   (2 3)   (2 3)   (2)    (2)      ()
*   resStack: ()   ("")  ("")   ()   ()  (aaa) (aaa) (aaa)  (aaa b) (aaa b)  (aaa) (aaa)     ()
*        res: ""    ""    a     aaa  aaa   ""   b      b       ""     d      bddd  bdddc  aaabdddcbdddc
*/
class Solution 
{
public:
	string decodeString(string s) 
	{
		stack<string> chars;
		stack<int> nums;
		string result="";
		int num = 0;
		for (char c : s) 
		{
			if (isdigit(c)) 
			{
				num = num * 10 + (c - '0');//如果重复了23次等,先读了2,要*10再加3
			}
			else if (isalpha(c)) 
			{
				result+=c;
			}
			else if (c == '[') 
			{
				chars.push(result);
				nums.push(num);
				result = "";
				num = 0;
			}
			else if (c == ']') 
			{
				string temp = result;
				for (int i = 0; i < nums.top() - 1; ++i) 
				{
					result += temp;
				}
				result = chars.top() + result;
				chars.pop(); nums.pop();
			}
		}
		return result;
	}
};
```
