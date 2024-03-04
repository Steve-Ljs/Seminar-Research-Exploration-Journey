```
给定一个具有红色，白色或蓝色的n个对象的数组，对它们进行就地 排序，使相同颜色的对象相邻，颜色顺序为红色，白色和蓝色。

这里，我们将使用整数0,1和2分别表示红色，白色和蓝色。

注意：  您不应该使用库的排序功能来解决此问题。

例：

输入： [2,0,2,1,1,0]
 输出： [0,0,1,1,2,2]
跟进：

一个相当直接的解决方案是使用计数排序的两遍算法。
首先，迭代0,1，和2的数组计数，然后覆盖总数为0的数组，然后是1，然后是2。
你能想出一个只使用恒定空间的一次通过算法吗？
```

```c++
class Solution 
{
public:
	void sortColors(vector<int>& nums) 
	{
		//三向快排
		for (int k = 0; k != nums.size(); ++k)
		{
			if (nums[k] == 1)
			{
				swap(nums[k], nums[0]);
				break;
			}
		}
		int lo = 0, hi = 0,i=1,j=nums.size()-1;
		while (i <= j)
		{
			if (nums[i] == nums[lo])
			{
				++hi;
				++i;
			}
			else if (nums[i] < nums[lo])
			{
				swap(nums[lo++], nums[i++]);
				++hi;
			}
			else
				swap(nums[i], nums[j--]);
		}
	}
};
```

```c++
class Solution 
{
public:
	void sortColors(vector<int>& nums) 
	{
		int n = nums.size();
		int second = n - 1, zero = 0;
		for (int i = 0; i <= second; ++i) //second的右边全是2,所以遇到second就可以结束了
		{
			while (nums[i] == 2 && i < second) swap(nums[i], nums[second--]);//i<second是避免全是2死循环
			while (nums[i] == 0 && i > zero) swap(nums[i], nums[zero++]);//zero左边全是0
		}
	}
};
```
