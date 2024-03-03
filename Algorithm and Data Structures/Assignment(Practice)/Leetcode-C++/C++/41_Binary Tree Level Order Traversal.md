```
给定二叉树，返回其节点值的级别顺序遍历。（即，从左到右，逐级）。

例如：
给定二叉树[3,9,20,null,null,15,7]，
    3
   / \
  9 20
    / \
   15 7
返回其级别顺序遍历为：
[
  [3]，
  [9,20]，
  [15,7]
]
```


```c++
class Solution 
{
public:
	vector<vector<int>> levelOrder(TreeNode* root) 
	{
		vector<vector<int>>  result;
		if (!root) return result;
		queue<TreeNode*> q;
		q.push(root);
		q.push(NULL);
		vector<int> current_vec;
		while (!q.empty()) 
		{
			TreeNode* x = q.front();
			q.pop();
			if (x == NULL) 
			{
				result.push_back(current_vec);
				current_vec.resize(0);
				if (q.size() > 0) 
				{
					q.push(NULL);
				}
			}
			else 
			{
				current_vec.push_back(x->val);
				if (x->left) q.push(x->left);
				if (x->right) q.push(x->right);
			}
		}
		return result;
	}
};
```

```c++
//dfs 速度较慢
class Solution 
{
public:
	vector<vector<int>> levelOrder(TreeNode* root) 
	{
		vector<vector<int>> result;
		if (!root)
			return result;
		recursive(root, result,0);
		return result;
	}
	void recursive(TreeNode* root, vector<vector<int>>& result,int n)
	{
		if (n == result.size())
			result.push_back({ root->val });
		else
			result[n].push_back(root->val);
		if (root->left)
			recursive(root->left, result,n+1);
		if (root->right)
			recursive(root->right, result,n+1);
	}
};
```
