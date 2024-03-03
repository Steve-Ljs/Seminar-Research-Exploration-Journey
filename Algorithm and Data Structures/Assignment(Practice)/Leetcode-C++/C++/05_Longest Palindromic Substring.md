```
给定一个字符串小号，发现最长的回文子小号。您可以假设s的最大长度为1000。

例1：

输入： “babad”
 输出： “bab”
 注意： “aba”也是一个有效的答案。
例2：

输入： “cbbd”
 输出： “bb”
 ```
 
 ```c++
 //我是用一个循环,然后分奇偶,查看左右两端是否合适
string longestPalindrome(string s) 
	{
		if (s.size() <= 1) return s;
		int min_start = 0, max_len = 1;//如果没有重复的,将截取第一个字符
		for (int i = 0; i < s.size();) 
		{
			if (max_len >= 2 * (s.size() - i))//剩下的再怎么扩展都达不到max_len了
				break;
			int j = i, k = i;
			while (k < s.size() - 1 && s[k + 1] == s[k]) 
				++k; // 跳过重复字符,还可以避免讨论奇偶,跳过后只需要讨论左右两边的是否相等
			i = k + 1;//下一次将跳过重复的元素进行判断,重复元素的地方交给此时的j和k
			//此时j在重复元素的第一个,k在重复元素的最后一个
			while (k < s.size() - 1 && j > 0 && s[k + 1] == s[j - 1]) 
			{ 
				++k;
				--j; 
			} // 不断扩展
			int new_len = k - j + 1;
			if (new_len > max_len) 
			{
				min_start = j; 
				max_len = new_len; 
			}
		}
		return s.substr(min_start, max_len);
	}
 ```
