```
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```

```c++
//递归
class Solution 
{
public:
	vector<int> inorderTraversal(TreeNode* root) 
	{
		vector<int> result;
		recursive(result, root);
		return result;
	}
private:
	void recursive(vector<int>& result,TreeNode * x)
	{
		if (!x)
			return;
		recursive(result, x->left);
		result.push_back(x->val);
		recursive(result, x->right);

	}
};
```

```c++
//迭代
class Solution 
{
public:
	vector<int> inorderTraversal(TreeNode* root) 
	{
		vector<int> result;
		stack<TreeNode*> treeNode_stack;
		while (root || !treeNode_stack.empty()) 
		{
			while (root) 
			{
				treeNode_stack.push(root);
				root = root->left;
			}
			root = treeNode_stack.top();
			treeNode_stack.pop();
			result.push_back(root->val);
			root = root->right;
		}
		return result;
	}
};
```
