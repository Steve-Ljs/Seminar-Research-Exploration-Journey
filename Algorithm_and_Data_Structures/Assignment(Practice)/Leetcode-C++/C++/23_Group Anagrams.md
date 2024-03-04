```
给定一个字符串数组，将字谜组合在一起。

例：

输入： ["eat", "tea", "tan", "ate", "nat", "bat"]，
 输出：
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
注意：

所有输入都是小写的。
输出的顺序无关紧要
```

```c++
static const auto __ = []() 
{
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	return nullptr;
}();
class Solution
{
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) 
	{
		vector<vector<string>> result;
		unordered_map<unsigned, int> string_index;//相当于存string和他们的组别
		int alpha[26] = { 2,3,5,7,11,13,17,19,23,29,31,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103 };//素数
		//用一个大小为26的int数组来统计每个单词中字符出现的次数，然后将int数组转为一个唯一的字符串，
		//跟字符串数组进行映射，这样我们就不用给字符串排序了
		int current = 0;//第0组
		for (string s : strs) 
		{
			unsigned key = 1;
			for (char c : s) 
				key *= alpha[c - 'a'];//c-'a'得到0-26  key存这个string的unsigned值
			if (string_index.find(key) == string_index.end()) //没存过这个类型的string,新组别
			{
				string_index[key] = current++;
				result.push_back({ s });
			}
			else 
				result[string_index[key]].push_back(s);
		}
		return result;
	}
};
```
