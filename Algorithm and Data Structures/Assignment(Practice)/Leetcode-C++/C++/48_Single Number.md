```
给定一个非空  的整数数组，除了一个元素外，每个元素都会出现两次。找一个单一的。

注意：

您的算法应具有线性运行时复杂性。你能不用额外的内存来实现吗？

例1：

输入： [2,2,1]
 输出： 1
例2：

输入： [4,1,2,1,2]
 输出： 4
```

```c++
class Solution 
{
public:
	int singleNumber(vector<int>& nums) 
	{
		int result = nums[0];
		for (int i = 1; i != nums.size(); ++i) 
			result ^= nums[i];
		//A^ A = 0且A ^ B ^ A = B.
		//因为其他元素都会出现两次,所以把所有的都^就只剩下一个的了
		return result;
	}
};
```

```c++
//排序方法,很慢
class Solution 
{
public:
	int singleNumber(vector<int>& nums) 
	{
		sort(nums.begin(), nums.end());
		for (int i = 0; i != nums.size() - 1; i += 2) 
			if (nums[i] != nums[i + 1]) return nums[i];
		return nums[nums.size() - 1];
	}
};
```
