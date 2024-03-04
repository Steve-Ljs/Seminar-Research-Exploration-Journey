```
序列化是将数据结构或对象转换为比特序列的过程，以便它可以存储在文件或存储缓冲器中，或者通过网络连接链路传输，以便稍后在相同或另一个计算机环境中重建。

设计一种算法来序列化和反序列化二叉树。序列化/反序列化算法的工作方式没有限制。您只需要确保二进制树可以序列化为字符串，并且可以将此字符串反序列化为原始树结构。

例： 

您可以序列化以下树：

    1
   / \
  2   3
     / \
    4   5

如 "[1,2,3,null,null,4,5]"
澄清：以上格式与LeetCode序列化二叉树的方式相同。您不一定需要遵循这种格式，因此请发挥创意并自己提出不同的方法。

注意： 不要使用类成员/全局/静态变量来存储状态。您的序列化和反序列化算法应该是无状态的。
```

```c++
class Codec 
{
public:
	string serialize(TreeNode* root) 
	{
		ostringstream out;//stringstream通常是用来做数据转换的
		serialize(root, out);
		return out.str();
	}

	TreeNode* deserialize(string data) 
	{
		istringstream in(data);
		return deserialize(in);
	}

private:
	void serialize(TreeNode* root, ostringstream& out) 
	{
		if (root) 
		{
			out << root->val << ' ';
			serialize(root->left, out);
			serialize(root->right, out);
		}
		else 
			out << "# ";
	}

	TreeNode* deserialize(istringstream& in) 
	{
		string val;
		in >> val;
		if (val == "#")
			return nullptr;
		TreeNode * root = new TreeNode(stoi(val));//stoi()将string变为int
		root->left = deserialize(in);
		root->right = deserialize(in);
		return root;
	}
};
//"1 2 # # 3 4 # # 5 # #"
/*
	1
   / \
  2   3
	 / \
	4   5
*/
```
