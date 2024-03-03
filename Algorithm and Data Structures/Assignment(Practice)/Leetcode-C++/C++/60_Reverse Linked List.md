```
反转单链表。

例：

输入： 1-> 2-> 3-> 4-> 5-> NULL
 输出： 5-> 4-> 3-> 2-> 1-> NULL
跟进：

链接列表可以反复或递归地反转。你能同时实施吗？
```

```c++
class Solution 
{
public:
	ListNode* reverseList(ListNode* head) 
	{
		stack<int> s;
		while (head)
		{
			s.push(head->val);
			head = head->next;
		}
		if (s.empty())
			return NULL;
		head =new ListNode(-1);
		ListNode* current=head;
		while (!s.empty())
		{
			current->next = new ListNode(s.top());
			s.pop();
			current = current->next;
		}
		return head->next;
	}
};
```
