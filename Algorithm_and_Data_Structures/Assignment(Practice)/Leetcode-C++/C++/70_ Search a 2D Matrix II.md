```
编写一个有效的算法，搜索m × n矩阵中的值。该矩阵具有以下属性：

每行中的整数按从左到右的升序排序。
每列中的整数按从上到下的顺序排序。
例：

考虑以下矩阵：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定target =  5，返回  true。

给定target =  20，返回  false。
```

```c++
class Solution 
{
public:
	bool searchMatrix(vector<vector<int>>& matrix, int target) 
	{
		if (matrix.empty()) return false;
		int m = matrix.size(),n = matrix[0].size();
		int up = 0;//从0开始的行
		--n;
		while (n >= 0 && up < m) 
		{
			if (target > matrix[up][n]) //一行之中最大的一个还是小于target的话,只能跑到下一行了
				up++;
			else if (target < matrix[up][n]) //往左找
				n--;
			else 
				return true;
		}
		return false;
	}
};
```
