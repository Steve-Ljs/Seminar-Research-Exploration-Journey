```
给定二叉树，找到它的最大深度。

最大深度是从根节点到最远叶节点的最长路径上的节点数。

注意：  叶子是没有子节点的节点。

例：

给定二叉树[3,9,20,null,null,15,7]，

    3
   / \
  9 20
    / \
   15 7
返回其深度= 3。
```

```c++
class Solution 
{
public:
	int maxDepth(TreeNode* root) 
	{
		if (!root) return 0;
		return 1 + max(maxDepth(root->left), maxDepth(root->right));
	}
};
```
