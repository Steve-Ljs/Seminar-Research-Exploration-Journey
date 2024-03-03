```
给定一个数组nums，写一个函数将所有0的移动到它的末尾，同时保持非零元素的相对顺序。

例：

输入： [0,1,0,3,12]
输出： [1,3,12,0,0]
注意：

您必须就地执行此操作，而无需复制阵列。
最小化操作总数。
```

```c++
class Solution 
{
public:
	void moveZeroes(vector<int>& nums) 
	{
		if (nums.empty()) return;
		int lo = -1;//lo,hi表示第一个0的位置,连续的时候
		for (int i = 0; i < nums.size()-1;++i)
		{
			if (nums[i] == 0)
			{
				if (lo == -1)//第一次初始化lo为第一个0出现的位置
					lo = i;
				nums[lo] = nums[i + 1];//确保了lo,i的位置全为0，这样换就没有风险
				nums[i + 1] = 0;
				if (nums[lo] != 0)
					++lo;
			}
		}
	}
};
```
