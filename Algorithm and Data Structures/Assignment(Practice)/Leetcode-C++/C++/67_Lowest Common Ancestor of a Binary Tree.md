```
给定二叉树，找到树中两个给定节点的最低共同祖先（LCA）。

根据维基百科上LCA的定义：“最低共同祖先在两个节点p和q之间定义为T中的最低节点，其中p和q都是后代（我们允许节点成为其自身的后代）。 ”

给出以下二叉树：root = [3,5,1,6,2,0,8，null，null，7,4]


 

例1：

输入： root = [3,5,1,6,2,0,8，null，null，7,4]，p = 5，q = 1
 输出： 3
 说明：节点的LCA 5和1是3.
例2：

输入：根= [3,5,1,6,2,0,8，NULL，NULL，7,4]，P = 5，Q = 4
 输出： 5
 说明：节点的LCA 5和4是5，由于节点根据LCA定义，它可以是自身的后代。
 

注意：

所有节点的值都是唯一的。
p和q不同，两个值都将存在于二叉树中。
```

```c++
class Solution 
{
public:
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) 
	{
		if (!root || root == p || root == q) return root; //开始的话,如果p,q有一个为root,直接可以返回root,root为NULL也返回NULL
		//因为是递归,如果是之后的情况,则相当于返回了root和left所在的位置,如果找到头了还找不到,返回NULL
		TreeNode * left = lowestCommonAncestor(root->left, p, q); 
		TreeNode * right = lowestCommonAncestor(root->right, p, q);
		return !left ? right : !right ? left : root; //如果一边找不到,那么说明在同一侧,则返回找到的那一侧即可.如果两边各找到一个,返回他们的根节点
	}
};
```
