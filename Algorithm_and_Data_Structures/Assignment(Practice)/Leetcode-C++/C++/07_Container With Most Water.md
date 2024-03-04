```
给定n个非负整数a 1，a 2，...，a n ，其中每个表示坐标（i，a i）处的点。绘制n条垂直线，使得线i的两个端点位于（i，a i）和（i，0）。找到两条线，它们与x轴一起形成一个容器，这样容器就含有最多的水。

注意： 您可能不会倾斜容器，n至少为2。
上面的垂直线由数组[1,8,6,2,5,4,8,3,7]表示。在这种情况下，容器可容纳的最大水面积（蓝色部分）为49。
例：
输入： [1,8,6,2,5,4,8,3,7]
 产出： 49
```
```c++
//挺简单
class Solution 
{
public:
	int maxArea(vector<int>& height) 
	{
		int water = 0;
		int i = 0, j = height.size() - 1;
		while (i < j) 
		{
			int h = min(height[i], height[j]);
			water = max(water, (j - i) * h);
			while (height[i] <= h && i < j) i++;//随着距离减小,高度不比之前高的话,面积肯定不够大
			while (height[j] <= h && i < j) j--;
		}
		return water;
	}
};
```
