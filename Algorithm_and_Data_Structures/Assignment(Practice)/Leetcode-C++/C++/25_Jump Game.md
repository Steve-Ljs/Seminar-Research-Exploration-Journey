```
给定一个非负整数数组，您最初定位在数组的第一个索引处。

数组中的每个元素表示该位置的最大跳转长度。

确定您是否能够到达最后一个索引。

例1：

输入： [2,3,1,1,4]
 输出： true
 说明：从索引0跳转1步到1，然后从最后一个索引跳3步。
例2：

输入： [3,2,1,0,4] 输出： false
 说明：无论如何，
 您总是会到达索引3。它的最大值
 跳转长度为0，这使得无法到达最后一个索引。
```

```c++
//自己的解法,速度也还行
class Solution 
{
public:
	bool canJump(vector<int>& nums) 
	{
		int jump = nums[0];
		if (jump >= nums.size() - 1)
			return true;
		int lo = 1;
		int max_jump = 0;
		while (true)
		{
			for (; lo <= jump; ++lo)
				max_jump = max(max_jump, nums[lo] - (jump - lo));
			if (max_jump + jump >= nums.size() - 1)
				return true;
			if (max_jump == 0)
				return false;
			lo = jump + 1;
			jump = max_jump+jump;
			max_jump = 0;
		}
	}
};
```

```c++
//比较简短的解法,速度相差不大
class Solution 
{
public:
	bool canJump(vector<int>& nums)
	{
		int i = 0;
		for (int reach = 0; i < nums.size() && i <= reach; ++i)//最多跳到reach处
			reach = max(i + nums[i], reach);
		return i == nums.size();//能顺利跳完数组
	}
};
```

