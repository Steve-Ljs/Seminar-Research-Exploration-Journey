```
给定包含包含数字的字符串2-9，返回该数字可能表示的所有可能的字母组合。

下面给出了数字到字母的映射（就像在电话按钮上一样）。请注意，1不会映射到任何字母。
例：
输入： “23”
 输出： [“ad”，“ae”，“af”，“bd”，“be”，“bf”，“cd”，“ce”，“cf”]。
注意：
虽然上面的答案是按字典顺序排列的，但您的答案可能是您想要的任何顺序。
```

```c++
class Solution 
{
public:
	vector<string> letterCombinations(string digits) 
	{
		vector<string> result;
		string temp = "";
		int n = digits.length();
		string num_to_letters[]= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		if (n == 0)
			return result;
		all_combine(digits, result, temp, n, 0, num_to_letters);
		return result;
	}

	void all_combine(string digits, vector<string> &result, string temp,int n, int start, string num_to_letters[])
	{
		if (start == n)//start记录到第几个元素了,如果全部处理过了,就可以返回了
		{
			result.push_back(temp);
			return;
		}
		int first = digits[start] - '0';//0-9的char字符-'0'得到它代表的数字
		int len = num_to_letters[first].length();
		for (int i = 0; i < len; i++)
			all_combine(digits, result, temp + num_to_letters[first][i], n, start + 1, num_to_letters);
	}
};
```
