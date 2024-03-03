```
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
```

```c++
class Solution 
{
public:
	bool isValidBST(TreeNode* root)
	{
	  return recursive(root, NULL, NULL);
	}
	bool recursive(TreeNode* root, TreeNode* min, TreeNode* max) 
	{
		if (root == NULL) return true;//第一步将判断root是否存在
		if (min && root->val <= min->val) return false;//如果是root,这两步会跳过
		if (max && root->val >= max->val) return false;
    //往root的左右走,左边设置最大值为此时的root,右边设置最小值为此时root
		return recursive(root->left, min, root) && recursive(root->right, root, max);
	}
};
```
