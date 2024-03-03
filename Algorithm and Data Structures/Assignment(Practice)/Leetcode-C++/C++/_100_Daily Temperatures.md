```
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead. 
For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0]. 
Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. 
```


```c++
#include<string>
#include<vector>

using namespace std;

//T = [73, 74, 75, 71, 69, 72, 76, 73]
class Solution 
{
public:
	vector<int> dailyTemperatures(vector<int>& temperatures) 
	{
		vector<int> result(temperatures.size());
		for (int i = temperatures.size() - 1; i >= 0; --i) 
		{
			int j = i + 1;
			//不进循环的说明右边一位就是比较热的
			while (j < temperatures.size() && temperatures[j] <= temperatures[i]) 
			{
				if (result[j] > 0) //说明右边有更好的
				{
					j = result[j] + j;//今天的加上所代表的更好的所在位置
				}
				else//直接滚了
				{
					j = temperatures.size();
				}
			}
			// 如果是右边没有更好的，则默认为0了
			if (j < temperatures.size())
			{
				result[i] = j - i;
			}
		}
		return result;
	}
};
```
