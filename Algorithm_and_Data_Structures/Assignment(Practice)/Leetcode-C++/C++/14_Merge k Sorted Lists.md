```
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

```c++
class Solution 
{
public:
	ListNode* mergeKLists(vector<ListNode*>& lists) 
	{
		if (lists.empty()) return NULL;
		int n = lists.size();
		while (n > 1) //分治法
		{
			int k = (n + 1) / 2;
			for (int i = 0; i != n / 2; ++i) 
			{
				lists[i] = mergeTwoLists(lists[i], lists[i + k]);
			}
			n = k;
		}
		return lists[0];
	}

	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) //归并两个链表
	{
		ListNode *head = new ListNode(-1), *current = head;
		while (l1 && l2) 
		{
			if (l1->val < l2->val) 
			{
				current->next = l1;
				l1 = l1->next;
			}
			else 
			{
				current->next = l2;
				l2 = l2->next;
			}
			current = current->next;
		}
		current->next = l1 ? l1 : l2;
		return head->next;
	}
};
```
