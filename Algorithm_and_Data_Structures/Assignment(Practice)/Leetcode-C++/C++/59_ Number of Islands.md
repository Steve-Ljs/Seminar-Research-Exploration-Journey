```
给定'1's（土地）和'0's（水）的2d网格图，计算岛屿的数量。岛被水包围，
通过水平或垂直连接相邻的土地而形成。您可以假设网格的所有四个边都被水包围。

例1：
输入：
11110
11010
11000
00000

输出：  1
例2：

输入：
11000
11000
00100
00011

输出： 3
```

```c++
//只需注意是char类型而不是int
class Solution 
{
public:
	int numIslands(vector<vector<char>>& grid) 
	{
		if (grid.empty()) return 0;
		int count = 0;
		for (int i = 0; i != grid.size(); ++i)
		{
			for (int j = 0; j != grid[0].size(); ++j)
			{
				if (grid[i][j]=='0')
					continue;
				recursive(grid, i, j);
				++count;
			}
		}
		return count;
	}
private:
	void recursive(vector<vector<char>>& grid, int i, int j)
	{
		if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		recursive(grid, i - 1, j);
		recursive(grid, i + 1, j);
		recursive(grid, i, j - 1);
		recursive(grid, i, j + 1);
	}
};
```
