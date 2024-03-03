```
给定正整数n，找到1, 4, 9, 16, ...总和为n的最小正方数（例如）。

例1：

输入： n = 12
输出： 3 
说明：12 = 4 + 4 + 4.
例2：

输入： n = 13
输出： 2
说明：13 = 4 + 9.
```

```c++
class Solution
{
public:
	int numSquares(int n)
	{
		static vector<int> result({ 0 });//可以重复使用之前计算好点的
		while (result.size() <= n)
		{
			int m = result.size();
			int cntSquares = INT_MAX;
			for (int i = 1; i * i <= m; ++i)//m相当于这个数
			{
				cntSquares = min(cntSquares, result[m - i * i] + 1);//最小的为,最大的平方的1加上减去最大平方时的数
			}
			result.push_back(cntSquares);
		}
		return result[n];
	}
};
```
