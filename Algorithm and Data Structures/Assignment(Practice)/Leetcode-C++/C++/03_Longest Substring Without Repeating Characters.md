```
给定一个字符串，找到最长子字符串的长度而不重复字符。

例1：

输入：“abcabcbb” 
输出：3 
 说明：答案是"abc"，长度为3。 
例2：

输入：“BBBBB” 
输出：1
 说明：牛逼，他的回答是"b"，与1的长度。
例3：

输入：“pwwkew” 
输出：3
 说明：答案是"wke"，长度为3。
             请注意，答案必须是子字符串，"pwke"是子序列而不是子字符串。
```



```c++
//暴力解法
int lengthOfLongestSubstring(string s) 
	{
		int max = 0;
		if (s.size() == 0)
			return 0;
		for (int i=0;i!=s.size();i++)
		{
			string::const_iterator it = s.begin() + i;
			int count = 0;
			set<char> save;
			while (it != s.end()&&!save.count(*it))
			{
				save.insert(*it);
				++it;
				count++;
			}
			//save.insert();
			if (max < count)
				max = count;
		}
		return max;
	}
  ```
  ```c++
  //我的天,难
  /*
  手动推导的方法实际上是维护了一个滑动窗口，窗口内的都是没有重复的字符，我们需要尽可能的扩大窗口的大小。
  由于窗口在不停向右滑动，所以我们只关心每个字符最后出现的位置，并建立映射。
  窗口的右边界就是当前遍历到的字符的位置，为了求出窗口的大小，我们需要一个变量left来指向滑动窗口的左边界，
  这样，如果当前遍历到的字符从未出现过，那么直接扩大右边界，
  如果之前出现过，那么就分两种情况，在或不在滑动窗口内，如果不在滑动窗口内，那么就没事，当前字符可以加进来，
  如果在的话，就需要先在滑动窗口内去掉这个已经出现过的字符了，去掉的方法并不需要将左边界left一位一位向右遍历查找，
  由于我们的HashMap已经保存了该重复字符最后出现的位置，所以直接移动left指针就可以了。
  我们维护一个结果res，每次用出现过的窗口大小来更新结果res，就可以得到最终结果啦。
  */
  vector<int> dict(256, -1);//ASCII表共能表示256个字符，所以可以记录所有字符
		int maxLen = 0, start = -1;//start指向该无重复子串左边的起始位置
		for (int i = 0; i != s.length(); i++)
		{
			if (dict[s[i]] > start)//有重复的了
				start = dict[s[i]];
			dict[s[i]] = i;
			maxLen = max(maxLen, i - start);
		}
		return maxLen;
```
