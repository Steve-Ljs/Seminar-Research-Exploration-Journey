```
给定非空二叉树，找到最大路径总和。

对于此问题，路径定义为沿着父子连接从树中的某个起始节点到任何节点的任何节点序列。该路径必须至少包含一个节点，并且不需要通过根节点。

例1：

输入： [1,2,3]

       1
      / \
     2   3

产量： 6
例2：

输入： [ -  10,9,20，null，null，15,7]

   -10
   / \
  9  20
    /  \
   15   7

产量： 42
```

```c++
class Solution 
{
public:
	int maxPathSum(TreeNode* root) 
	{
		int maxSum = INT_MIN;
		DFS(root, maxSum);
		return maxSum;
	}

	int DFS(TreeNode* root, int& maxSum) 
	{
		if (!root) return 0;
		int left = max(0, DFS(root->left, maxSum));
		int right = max(0, DFS(root->right, maxSum));
		maxSum = max(maxSum, left + right + root->val);
		return max(left, right) + root->val;//返回单支最大的一个
	}
};
```
