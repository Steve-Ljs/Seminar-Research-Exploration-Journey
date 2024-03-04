```
给定大小为n的数组，找到多数元素。多数元素是appears more than ⌊ n/2 ⌋ times.。

您可以假设该数组非空，并且多数元素始终存在于数组中。

例1：

输入： [3,2,3]
 输出： 3
例2：

输入： [2,2,1,1,1,2,2]
 输出： 2
```

```c++
class Solution
{
public:
	int majorityElement(vector<int>& nums)
	{
		int result = 0;
		int count = 0;
		for (const int& i : nums)
		{
			if (count == 0) result = i;
			if (result == i) ++count;
			else --count;
		}
		return result;
	}
};
```
