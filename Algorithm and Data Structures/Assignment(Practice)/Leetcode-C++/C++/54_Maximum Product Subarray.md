```
给定一个整数数组  nums，找到具有最大乘积的数组（包含至少一个数字）中的连续子数组。

例1：
输入： [2,3，-2,4]
 输出： 6
说明：  [2,3]具有最大的乘积6。

例2：
输入： [ -  2,0，-1]
 输出： 0
 说明：  结果不能为2，因为[-2，-1]不是子数组。
```

```c++
class Solution 
{
public:
	int maxProduct(vector<int>& nums) 
	{
		if (nums.empty()) return 0;
		int result = nums[0];
		int maxVal = nums[0];
		int minVal = nums[0];
		for (int i = 1; i != nums.size(); ++i) //因为可能有负数的情况,所以同时存最小最大很有必要
		{
			int temp = minVal;//因为下一条语句把minVal改为了当前的i的minVal
			minVal = min(nums[i], min(nums[i] * minVal, nums[i] * maxVal));
			maxVal = max(nums[i], max(nums[i] * temp, nums[i] * maxVal));//需要的是i-1的minVal所以用temp
			result = max(result, maxVal);
		}
		return result;
	}
};
```
