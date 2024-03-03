```
给定树的preorder和inorder遍历，构造二叉树。

注意：
您可以假设树中不存在重复项。

例如，给定

preorder= [3,9,20,15,7]
inorder = [9,3,15,20,7]
返回以下二叉树：

    3
   / \
  9  20
    /  \
   15   7
```


```c++
//非递归
class Solution 
{
public:
	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) 
	{
		if (preorder.size() == 0) return NULL;
		TreeNode * current = new TreeNode(preorder.front());
		if (preorder.size() == 1) return current;

		TreeNode * root = current;
		stack<TreeNode*> tree_stack; 
		int index_inorder = 0, index_preorder = 1;
		tree_stack.push(root);
		while (!tree_stack.empty()) 
		{
			while (inorder[index_inorder] != current->val) //左边有值 
			{
				current->left = new TreeNode(preorder[index_preorder++]);
				current = current->left;//继续向左
				tree_stack.push(current);
			}
			//如果右边没有值,则继续向上,直到有值或者root
			while (!tree_stack.empty() && tree_stack.top()->val == inorder[index_inorder]) 
			{
				current = tree_stack.top();
				tree_stack.pop();
				index_inorder++;
			}
			if (index_preorder < preorder.size()) 
			{
				current->right = new TreeNode(preorder[index_preorder++]);
				current = current->right;
				tree_stack.push(current);
			}
		}
		return root;
	}
};
```

```c++
//递归
class Solution
{
public:

	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) 
	{
		return create(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
	}
private:
	TreeNode* create(vector<int> & preorder, vector<int> & inorder, int pre_lo, int pre_hi, int in_lo, int in_hi) 
	{
		if (pre_lo > pre_hi) return nullptr;
		TreeNode* node = new TreeNode(preorder[pre_lo]);
		int pos=0;
		for (int i = in_lo; i <= in_hi; ++i) 
		{
			if (inorder[i] == node->val) 
			{
				pos = i;
				break;
			}
		}
		//[in_lo, pos - 1] inorder的左子树  ,[pre_lo + 1, pre_lo + pos - in_lo] preorder的左子树
		node->left = create(preorder, inorder, pre_lo + 1, pre_lo + pos - in_lo, in_lo, pos - 1);
		node->right = create(preorder, inorder, pre_hi - in_hi + pos + 1, pre_hi, pos + 1, in_hi);
		return node;
	}
};
```
