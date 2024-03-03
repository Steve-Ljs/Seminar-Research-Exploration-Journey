```
You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000. 
Example: 
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```


```c++
#include<iostream>
#include<string>
#include<vector>
#include<unordered_map>
#include<unordered_set>

using namespace std;

struct TreeNode 
{
	int val;
	TreeNode *left,*right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
/*
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
*/

class Solution 
{
public:
	//从root开始，逐层向下，以那个节点作为头部开始累加
	int pathSum(TreeNode* root, int sum) 
	{
		if (!root)  return 0;
		return sumUp(root, 0, sum) + pathSum(root->left, sum) + pathSum(root->right, sum);
	}
private:
	//sumUp表示，从某个特定头部开始累加，如果头部等于，或者头部加上左边等于，或者加上右边等于，则++sum
	//注意的是，算的是所有从这个头部开始的累加，结果有可能大于三
	int sumUp(TreeNode* root, int pre, int sum) 
	{
		if (!root) return 0;
		int current = pre + root->val;
		return (current == sum) + sumUp(root->left, current, sum) + sumUp(root->right, current, sum);
	}
};


int main()
{
	/*TreeNode* root = new TreeNode(10);
	root->left= new TreeNode(5);
	root->right= new TreeNode(-3);
	root->left->left = new TreeNode(3);
	root->left->right = new TreeNode(2);
	root->right->right = new TreeNode(11);
	root->left->left->left = new TreeNode(3);
	root->left->left->right = new TreeNode(-2);
	root->left->right->right = new TreeNode(1);*/


	TreeNode* root = new TreeNode(1);
	root->right= new TreeNode(2);
	root->right->right= new TreeNode(3);
	root->right->right->right= new TreeNode(4);
	root->right->right->right->right= new TreeNode(5);

	Solution s;
	int i = s.pathSum(root,3);
	cout << i << endl;
}
```
