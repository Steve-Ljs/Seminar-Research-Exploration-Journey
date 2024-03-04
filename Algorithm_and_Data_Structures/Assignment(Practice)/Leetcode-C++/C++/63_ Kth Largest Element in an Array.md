```
找到未排序数组中的第k个最大元素。请注意，它是排序顺序中的第k个最大元素，而不是第k个不同元素。

例1：

输入： [3,2,1,5,6,4] 和k = 2
 输出： 5
例2：

输入： [3,2,3,1,2,4,5,5,6] 和k = 4
 输出： 4
注意：
您可以假设k始终有效，1≤k≤数组的长度
```
```c++
class Solution 
{
public:
	int findKthLargest(vector<int>& nums, int k) 
	{
		sort(nums.begin(), nums.end());
		for (int i = nums.size() - 1; i >= 0; --i)
		{
			if (--k == 0)
				return nums[i];
		}
		return -1;
	}
};
```
