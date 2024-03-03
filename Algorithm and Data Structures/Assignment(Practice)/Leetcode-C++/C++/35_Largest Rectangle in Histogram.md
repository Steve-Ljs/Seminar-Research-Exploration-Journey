```
给定n个非负整数表示直方图的条形高度，其中每个条形的宽度为1，找到直方图中最大矩形的区域。
上面是一个直方图，其中每个条的宽度为1，给定高度= [2,1,5,6,2,3]。
最大的矩形显示在阴影区域中，其面积= 10单位。
例：
输入： [2,1,5,6,2,3]
 输出： 10
```

```c++
class Solution 
{
public:
	int largestRectangleArea(vector<int>& heights)
	{
		if (heights.empty()) return 0;
		// 在原数组首尾加上-1，保证所有元素都能出栈 
		heights.insert(heights.begin(), -1);
		heights.push_back(-1);
		stack<int> int_stack;
		int result = -1;
		for (int i = 0; i != heights.size(); ++i)
		{
			// 如果比栈顶元素大就直接进栈 注意存的是索引,所以比较的时候不能直接比较索引
			if (int_stack.empty() || heights[int_stack.top()] <= heights[i])//保证是递增的顺序
				int_stack.push(i);
			else
			{
				// 如果栈顶元素大于当前元素，则出栈 
				while (!int_stack.empty() && heights[int_stack.top()] > heights[i])//可以保证之后也是递增的顺序
				{
					int index = int_stack.top();
					int_stack.pop();
					result = max(result, heights[index] * (i - int_stack.top() - 1));//该方块的面积,或者以该方块为高,往右边叠加的面积,因为是递增的
				}
				int_stack.push(i);// 不要忘记把当前元素进栈 
			}
		}
		return result;
	}
};
```
