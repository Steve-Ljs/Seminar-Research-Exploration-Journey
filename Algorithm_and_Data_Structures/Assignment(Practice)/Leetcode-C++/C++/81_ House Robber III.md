```
小偷又发现了自己盗窃的新地方。这个区域只有一个入口，称为“根”。除了根，每个房子只有一个父母的房子。
查看一圈后，聪明的小偷意识到“这个地方的所有房屋都形成了一棵二叉树”。如果两个直接连接的房子在同一个晚上被闯入，它将自动联系警方。

确定小偷今晚可以抢劫的最大金额而不警告警察。

例1：

输入： [3,2,3，null，3，null，1]

     3
    / \
   2   3
    \   \ 
     3 1
 
输出： 7 
 说明：  小偷可以抢夺的最高金额= 3 + 3 + 1 = 7 。
例2：

输入： [3,4,5,1,3，null，1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

输出： 9
 说明：  小偷可以抢夺的最大金额= 4 + 5 = 9。
```

```c++
class Solution 
{
public:
	int rob(TreeNode* root) 
	{
		int robMax = 0, notRobMax = 0;
		return rob(root, robMax, notRobMax);
	}
private:
	int rob(TreeNode* root, int& robMax, int& notRobMax) 
	{
		if (!root) return 0;
		int leftRobMax = 0, leftNotRobMax = 0, rightRobMax = 0, rightNotRobMax = 0;
		int leftMax = rob(root->left, leftRobMax, leftNotRobMax);
		int rightMax = rob(root->right, rightRobMax, rightNotRobMax);
		robMax = root->val + leftNotRobMax + rightNotRobMax;
		notRobMax = leftMax + rightMax;
		return max(robMax, notRobMax);
	}
};
```

```c++
class Solution
{
public:
	int rob(TreeNode * root) 
	{
		vector<int> result = robSub(root);
		return max(result[0], result[1]);
	}
	vector<int> robSub(TreeNode * root) 
	{
		if (root == NULL) return vector<int>(2,0);
		vector<int> left = robSub(root->left);
		vector<int> right = robSub(root->right);
		vector<int> result = vector<int>(2, 0);
		result[0] = max(left[0], left[1]) + max(right[0], right[1]);
		result[1] = root->val + left[0] + right[0];
		return result;
	}
};
```
