```
给定二叉树，检查它是否是自身的镜像（即，围绕其中心对称）。

例如，这个二叉树[1,2,2,3,4,4,3]是对称的：

    1
   / \
  2   2
 / \ / \
3  4 4  3
但以下[1,2,2,null,3,null,3] 不是：
    1
   / \
  2   2
   \   \
   3    3
注意：
如果您可以递归和迭代地解决它
```

```c++
//递归
class Solution 
{
public:
	bool isSymmetric(TreeNode* root) 
	{
		if (root == NULL) 
			return true;
		return recursive(root->left, root->right);
	}
	bool recursive(TreeNode* left, TreeNode* right) 
	{
		//如果当前节点有一个空，另一个不空，这两个节点不一样，那么不是相同树
		if ((left == NULL && right != NULL) || (left != NULL && right == NULL))
			return false;
		//如果p,q都是空，说明递归到了根节点，两棵树是相同的
		if (left == NULL && right == NULL)
			return true;
		//两个节点都不是空的，这时候就得比较值是否一致
		if (left->val != right->val)
			return false;
		else 
			return recursive(left->left, right->right) && recursive(left->right, right->left);//精髓
	}
};
```

```c++
//迭代
class Solution 
{
public:
	bool isSymmetric(TreeNode* root)
	{
		if (root == NULL )return true;
		stack<TreeNode*> left_stack,right_stack;
		left_stack.push(root->left);
		right_stack.push(root->right);
		TreeNode* left_pop,* right_pop;

		while (!left_stack.empty() && !right_stack.empty()) 
		{
			left_pop = left_stack.top(); left_stack.pop();
			right_pop = right_stack.top(); right_stack.pop();
			if (left_pop == NULL && right_pop == NULL)
				continue;
			else if ((left_pop == NULL && right_pop != NULL) || (left_pop != NULL && right_pop == NULL) || (left_pop->val != right_pop->val))
				return false;
				left_stack.push(left_pop->right);
				left_stack.push(left_pop->left);
				right_stack.push(right_pop->left);
				right_stack.push(right_pop->right);
		}
		return true;
	}
};
```
