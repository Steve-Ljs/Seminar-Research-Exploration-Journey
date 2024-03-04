```
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5
```

```c++
class Solution 
{
public:
	ListNode* sortList(ListNode* head) 
	{
		if (head == NULL || head->next == NULL) return head;
		int length = 0;
		ListNode * current = head;
		while (current != NULL) 
		{
			++length;
			current = current->next;
		}
		ListNode* prev = head, * l1 = head, * l2;
		for (int i = 0; i != length / 2 - 1; ++i) 
			prev = prev->next;
		l2 = prev->next;
		prev->next = NULL;//切分成两个
		l1 = sortList(l1);//归并法,自上而下,把整个链表分成两个,四个,直到每个链表由当个组成,再合并成两个,四个,整个
		l2 = sortList(l2);
		return mergeTwoSortedLists(l1, l2);
	}

private:
	ListNode* mergeTwoSortedLists(ListNode* l1, ListNode* l2) 
	{
		if (l1 == NULL) return l2;
		if (l2 == NULL) return l1;
		if (l1->val < l2->val) 
		{
			l1->next = mergeTwoSortedLists(l1->next, l2);
			return l1;
		}
		else 
		{
			l2->next = mergeTwoSortedLists(l1, l2->next);
			return l2;
		}
		return NULL;
	}
};
```
