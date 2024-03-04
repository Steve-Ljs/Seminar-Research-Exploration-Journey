```
给出一个单链表，确定它是否是回文。

例1：

输入： 1-> 2
 输出： false
例2：

输入： 1-> 2-> 2-> 1
 输出： true
跟进：
你可以在O（n）时间和O（1）空间进行吗？
```

```c++
class Solution 
{
public:
	bool isPalindrome(ListNode* head) 
	{
		if (!head) return true;
		vector<int> vec;
		while (head)
		{
			vec.push_back(head->val);
			head = head->next;
		}
		for (int i = 0; i != vec.size() / 2; ++i)
		{
			if (vec[i] != vec[vec.size() - 1 - i])
				return false;
		}
		return true;
	}
};
```
