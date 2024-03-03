```
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.
Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
Example: 
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```


```c++
#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

#include<unordered_map>

using std::vector;
using std::string;
using std::cout;
using std::cin;
using std::endl;

/*
[4, 3, 2, 7, 8, 2, 3, 1]

实质是:1 1 1 1 0 0 1 1
但是不能用额外空间，所有直接破坏nums
所以，把该位置所代表的索引的值变为负数作为标记这位置有了元素
例如，nums[0]=4,就把第四个元素7变为-7，代表了有了4
当然，本来是负数的不能变了
最后，大于0的地方说明没有索引使得这里改变
*/

class Solution 
{
public:
	vector<int> findDisappearedNumbers(vector<int>& nums) 
	{
		int len = nums.size();
		for (int i = 0; i < len; ++i) 
		{
			int m = abs(nums[i]) - 1; // index start from 0
			nums[m] = nums[m] > 0 ? -nums[m] : nums[m];
		}
		vector<int> result;
		for (int i = 0; i < len; i++) 
		{
			if (nums[i] > 0) result.push_back(i + 1);
		}
		return result;
	}
};

···
