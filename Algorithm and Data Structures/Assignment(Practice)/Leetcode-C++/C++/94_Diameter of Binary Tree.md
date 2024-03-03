```
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root. 
Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3]. 
Note: The length of path between two nodes is represented by the number of edges between them. 
```


```c++
#include<iostream>
#include<algorithm>

using namespace std;

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
	int diameterOfBinaryTree(TreeNode* root) 
	{
		int diameter = 0;
		height(root, diameter);
		return diameter;
	}
private:
	int height(TreeNode* node, int& diameter) 
	{
		if (!node) 
		{
			return 0;
		}
		int lh = height(node->left, diameter);
		int rh = height(node->right, diameter);
		diameter = max(diameter, lh + rh);
		return 1 + max(lh, rh);
	}
};
 
int main()
{
	Solution s;
	TreeNode* root = new TreeNode(1);
	root->left= new TreeNode(2);
	root->left->left= new TreeNode(4);
	root->left->right= new TreeNode(5);
	root->right= new TreeNode(3);
	int result = s.diameterOfBinaryTree(root);
	cout << result;
}
```
