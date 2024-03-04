```
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

```c++
class Solution 
{
public:
	TreeNode* invertTree(TreeNode* root) 
	{
		if (!root) return NULL;
		TreeNode* temp_right = root->right;
		root->right = invertTree(root->left);
		root->left = invertTree(temp_right);
		return root;
	}
};
```
