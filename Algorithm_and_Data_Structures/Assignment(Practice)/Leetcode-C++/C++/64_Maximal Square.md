```
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
```

```c++
class Solution 
{
public:
	int maximalSquare(vector<vector<char>>& matrix) 
	{
		if (matrix.empty()) return 0;
		int m = matrix.size(), n = matrix[0].size();
		vector<int> height(n, 0),left(n, 0),right(n, n);
		int result=0;
		for(int i=0;i!=m;++i)
		{
			for (int j = 0; j != n; ++j)
			{
				if (matrix[i][j] == '1')
					++height[j];
				else
					height[j] = 0;
			}
			int count_left = 0;
			for (int j = 0; j != n; ++j)
			{
				if (matrix[i][j] == '0')
				{
					count_left = j + 1;
					left[j] = 0;
				}
				else
				{
					left[j] = max(left[j], count_left);
				}
			}
			int count_right = n;
			for (int j = n-1; j >= 0; --j)
			{
				if (matrix[i][j] == '0')
				{
					count_right = j;
					right[j] = n;
				}
				else
				{
					right[j] = min(right[j], count_right);
				}
			}
			for (int j = 0; j != n; ++j)
			{
				result = max(result, min(height[j], right[j] - left[j]) * min(height[j], right[j] - left[j]));
			}
		}
		return result;
	}
};
```
