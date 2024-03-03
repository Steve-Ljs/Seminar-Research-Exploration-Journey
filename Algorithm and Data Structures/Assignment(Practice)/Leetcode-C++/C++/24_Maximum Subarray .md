```
给定一个整数数组nums，找到具有最大总和并返回其总和的连续子数组（包含至少一个数字）。

例：

输入： [ -  2,1，-3,4，-1,2,1，-5,4]，
 输出： 6
 说明：  [4，-1,2,1]具有最大的和= 6。
跟进：

如果你已经找到O（n）解决方案，尝试使用分而治之的方法编写另一个解决方案，这是更微妙的。
```

```c++
class Solution 
{
public:
	int maxSubArray(vector<int>& nums)
	{
		int n = nums.size();
		vector<int> temp(n);
		temp[0] = nums[0];
		int max_sum = temp[0];
		for (int i = 1; i != n; ++i) 
		{
			temp[i] = nums[i] + (temp[i - 1] > 0 ? temp[i - 1] : 0);
			max_sum = max(max_sum, temp[i]);
		}
		return max_sum;
	}
};
```
