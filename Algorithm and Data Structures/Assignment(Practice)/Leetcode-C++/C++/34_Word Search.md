```
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
```

```c++
class Solution 
{
public:
	bool exist(vector<vector<char> > &board, string word) 
	{
		int m = board.size(),n = board[0].size();
		for (int i = 0; i != m; ++i)
			for (int j = 0; j != n; ++j)
				if (isFound(board,m,n, word.c_str(), i, j))
					return true;
		return false;
	}
private:
	bool isFound(vector<vector<char> > &board,int m,int n, const char* ptr_word, int i, int j)
	{
		if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '\0' || *ptr_word != board[i][j])//第一次需要首字母相等才下一步
			return false;
		if (*(ptr_word + 1) == '\0')//前面把不等的都过滤掉了,到了字符串结尾
			return true;
		char t = board[i][j];
		board[i][j] = '\0';//这一块在一次搜索中不能重复用,这次搜索结束后再返还
		//往四周找下一个元素
		if (isFound(board,m,n, ptr_word + 1, i - 1, j) || isFound(board,m,n, ptr_word + 1, i + 1, j) || 
			isFound(board,m,n, ptr_word + 1, i, j - 1) || isFound(board,m,n, ptr_word + 1, i, j + 1))
			return true;
		board[i][j] = t;
		return false;//四周没找到下一个元素
	}
};
```
