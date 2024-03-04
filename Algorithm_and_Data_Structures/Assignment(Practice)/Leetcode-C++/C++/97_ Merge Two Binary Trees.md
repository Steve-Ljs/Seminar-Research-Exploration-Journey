```
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
Example 1:
Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 
Note: The merging process must start from the root nodes of both trees.
```

```c++
//好久没自己写出来，还跑出了95%了
struct TreeNode 
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
 
class Solution 
{
public:
	TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) 
	{
		if (!t1)
		{
			return t2;
		}
		if (!t2)
		{
			return t1;
		}
		TreeNode* root;
		return merge(t1, t2, root);
	}

	TreeNode* merge(TreeNode* t1, TreeNode* t2,TreeNode * node)
	{
		if (!t1 && !t2)
		{
			return node;
		}
		if(!t1)
		{ 
			node = t2;
			return node;
		}
		if (!t2)
		{
			node = t1;
			return node;
		}
		node = new TreeNode(t1->val + t2->val);
		node->left = merge(t1->left, t2->left, node->left);
		node->right = merge(t1->right, t2->right, node->right);

		return node;
	}
};
```
