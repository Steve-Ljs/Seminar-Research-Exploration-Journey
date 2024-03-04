```
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
Example: 
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
```

```c++
using namespace std;

struct TreeNode 
{
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
 
//因为最大的是在右边，所以从右往左，每个都加上右边之和，就满足条件了
class Solution 
{
public:
	TreeNode* convertBST(TreeNode* root) 
	{
		travel(root);
		return root;
	}
private:
	int cur_sum = 0;
	void travel(TreeNode* root) 
	{
		if (!root) return;
		if (root->right) travel(root->right);

		root->val = (cur_sum += root->val);
		if (root->left) travel(root->left);
	}
};
```
