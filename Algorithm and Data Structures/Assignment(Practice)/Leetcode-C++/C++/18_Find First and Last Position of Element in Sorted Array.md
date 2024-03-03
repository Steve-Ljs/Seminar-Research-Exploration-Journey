```
给定nums按升序排序的整数数组，找到给定target值的起始位置和结束位置。

算法的运行时复杂度必须为O（log n）。

如果在阵列中找不到目标，则返回[-1, -1]。

例1：

输入： nums = [ 5,7,7,8,8,10]，target = 8
 输出： [3,4]
例2：

输入： nums = [ 5,7,7,8,8,10]，target = 6
 输出： [ -  1，-1]
 ```
 
 ```c++
 //第一次自己写出来的这么快
 class Solution 
{
public:
	vector<int> searchRange(vector<int>& nums, int target) 
	{
		int lo = 0, hi = nums.size() - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] < target)
			{
				lo = mid + 1;
			}
			else if (nums[mid] > target)
			{
				hi = mid - 1;
			}
			else
			{
				int left = mid, right = mid;
				while (left - 1 >= 0 && nums[left - 1] == nums[mid])
					--left;
				while (right + 1 < nums.size() && nums[right + 1] == nums[mid])
					++right;
				return { left,right };
			}
		}
		return { -1, -1 };
	}
};
```
