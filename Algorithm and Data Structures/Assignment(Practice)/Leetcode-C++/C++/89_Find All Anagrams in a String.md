```
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Example 1: 
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2: 
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```


```c++
//两个vec，当他们相等时，认为s含有p，开始svec只含有pvec的元素大小的
//后来相当于不断前移，svec去掉头，加上尾部
#include<iostream>
#include<string>
#include<vector>

#include<unordered_map>

using std::vector;
using std::string;
using std::cout;
using std::cin;
using std::endl;

class Solution {
public:
	vector<int> findAnagrams(string s, string p) 
	{
		vector<int> pv(26, 0), sv(26, 0), result;
		if (s.size() < p.size())
			return result;
		for (int i = 0; i < p.size(); ++i)
		{
			++pv[p[i] - 'a'];
			++sv[s[i] - 'a'];
		}
		if (pv == sv)
			result.push_back(0);
		for (int i = p.size(); i < s.size(); ++i)
		{
			++sv[s[i] - 'a'];
			--sv[s[i - p.size()] - 'a'];
			if (pv == sv)  
				result.push_back(i - p.size() + 1);
		}
		return result;
	}
};

int main()
{
	string s = "abab", p = "ab";
	Solution solution;
	vector<int> result=solution.findAnagrams(s, p);
	for (auto i : result)
	{
		cout << i << " ";
	}
}
```
