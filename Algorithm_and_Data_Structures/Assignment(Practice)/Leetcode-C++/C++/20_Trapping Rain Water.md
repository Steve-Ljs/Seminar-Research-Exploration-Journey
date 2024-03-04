```
给定n个非负整数表示每个柱的宽度为1的高程图，计算下雨后能够捕获的水量。


上面的高程图由数组[0,1,0,2,1,0,1,3,2,1,2,1]表示。在这种情况下，6个单位的雨水（蓝色部分）被困住。感谢Marcos贡献这个形象！

例：

输入： [0,1,0,2,1,0,1,3,2,1,2,1]
 输出： 6
```
```c++
//自己写的,速度还行,下面的是最快的一个
class Solution 
{
public:
	int trap(vector<int>& height) 
	{
		int lo = 0,hi=height.size()-1;
		for (int i = 0; i != height.size(); ++i,++lo)//使得lo为第一个非空
		{
			if (height[i])
				break;
		}
		int area=0;
		for (int i = lo; i < hi;)//=hi时,右边没有高度了,没有水
		{
			int right = i + 1;
			int temp = 0;
			while (right<=hi && height[i] > height[right])
			{
				temp += height[right];
				++right;
			}
			if (right == hi + 1)//特殊情况 到了结尾,且结尾的高度较小
			{
				//从右往左,同理,j==i时结束
				for (int j = hi; j != i; )
				{
					int left = j - 1;
					int temp_left = 0;
					while (height[left] < height[j])
					{
						temp_left += height[left];
						--left;
					}
					area += min(height[j], height[left])*(j- left - 1) - temp_left;
					j = left;
				}
				return area;
			}
			area += min(height[i], height[right])*(right - i - 1) - temp;
			i = right;
		}
		return area;
	}
};
```

```c++
/*
Lambda表达式 一个函数
C++用一个流缓冲区来同步C的标准流,通过std :: ios_base :: sync_with_stdio函数可以解除这种同步,节省时间
每次操作的时候（调用”<<” ”>>”）都要刷新（调用flush），这样增加了IO的负担，
通过tie(nullptr)来解除std :: cin和std :: cout之间的绑定，来降低IO的负担使效率提升
*/
static const auto __ = []() 
{
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	return nullptr;
}();
class Solution 
{
public:
	int trap(vector<int>& height) 
	{
		if (height.size() == 0) return 0;
		int n = height.size();
		int area = 0;
		vector<int> maxLeft(n), maxRight(n);
		//记录i的左右最高峰
		maxLeft[0] = height[0];
		maxRight[n - 1] = height[n - 1];
		for (int i = 1; i != n; ++i) 
			maxLeft[i] = max(height[i], maxLeft[i - 1]);
		for (int i = n - 2; i >= 0; --i) 
			maxRight[i] = max(height[i], maxRight[i + 1]);
		for (int i = 1; i < n - 1; ++i) //最左和最右两个不构成面积,不用计算
			area += (min(maxLeft[i], maxRight[i]) - height[i]);//相当于每个算自己位置存的水
		return area;
	}
};
```
