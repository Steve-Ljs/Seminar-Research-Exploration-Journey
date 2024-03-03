```
给定二叉树，将其平铺到链接列表中。

例如，给定以下树：

    1
   / \
  2   5
 / \   \
3   4   6
扁平的树应该看起来像：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

```c++
class Solution
{
public:
	void flatten(TreeNode* root)
	{
		if (!root) return;
		TreeNode* current = new TreeNode(-1);//没有意义,只是给个初始化而已
		stack<TreeNode*> s;
		s.push(root);
		while (!s.empty())
		{
			TreeNode* node = s.top(); s.pop();
			current->right = node;//要用的不是current,而只是想改变root指向的内容
			current->left = nullptr;
			current = current->right;
			if (node->right) s.push(node->right);
			if (node->left)  s.push(node->left);
		}
		//root = newRoot->right;这一步没有用,因为只有二级指针才能在函数里面改变指向
		//而root所指向的内容在前面的循环中已经改变了
	}
};
```

```c++
//递归
class Solution
{
public:
	void flatten(TreeNode* root)
	{
		if (!root) return;
		if (root->left)
		{
			flatten(root->left);
			node->right = root->right;
			root->right = root->left;
			root->left = NULL;
		}
		node = root;
		flatten(root->right);
	}
private:
	TreeNode *node;
};
```
