```
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
```

```c++
/*DP解决方案从第一行开始逐行进行。令第i行和第j列的最大矩形区域由[right（i，j） - left（i，j）] * height（i，j）计算。
所有3个变量left，right和height都可以通过前一行的信息以及当前行的信息来确定。因此它可以被视为DP解决方案。过渡方程是：
left（i，j）= max（left（i-1，j），cur_left），cur_left可以从当前行确定
right（i，j）= min（right（i-1，j），cur_right），cur_right可以从当前行确定
如果matrix [i] [j] =='1'，则height（i，j）= height（i-1，j）+ 1;
如果matrix [i] [j] =='0'，则height（i，j）= 0*/
class Solution 
{
public:
	int maximalRectangle(vector<vector<char> > &matrix) 
	{
		if (matrix.empty()) return 0;
		int m = matrix.size(),n = matrix[0].size();//right为实际为"1"的右边一位的位置,类似于end()
		vector<int> left(n,0), right(n,n), height(n,0);//n处记录着左右为1的left,right
		int max_area = 0;
		for (int i = 0; i != m; ++i) 
		{
			int cur_left = 0, cur_right = n;
			for (int j = 0; j != n; ++j) 
			{ 
				if (matrix[i][j] == '1') ++height[j];//继承了matrix[i-1][j]是否为1
				else height[j] = 0;
			}
			for (int j = 0; j != n; ++j) 
			{ 
				if (matrix[i][j] == '1') 
					left[j] = max(left[j], cur_left);//第一层是一样的,但后面几层,还对比了上一层的,确保上一层的这个地方也是'1'
				else //既然不继承它的高度,则按自己
				{ 
					left[j] = 0; //很关键的一步,如果头上是0则不用跟,按自己的左右最大来算
					cur_left = j + 1; 
				}
			}
			for (int j = n - 1; j >= 0; --j) 
			{
				if (matrix[i][j] == '1') 
					right[j] = min(right[j], cur_right);
				else 
				{ 
					right[j] = n; 
					cur_right = j; 
				}
			}
			for (int j = 0; j != n; ++j)
				max_area = max(max_area, (right[j] - left[j])*height[j]);//面积为[i,j]的左右和上
		}
		return max_area;
	}
};
```
