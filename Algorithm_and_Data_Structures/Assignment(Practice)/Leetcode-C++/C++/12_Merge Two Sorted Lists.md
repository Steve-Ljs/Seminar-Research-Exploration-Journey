```
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```
```c++
//递归
class Solution 
{
public:
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) //归并两个链表
	{
		ListNode * head=recursive(l1,l2);
		return head;
	}
private:
	ListNode* recursive(ListNode* l1, ListNode* l2) 
	{
		if (!l1)
			return l2;
		if (!l2)
			return l1;
		ListNode *current;
		if(l1->val < l2->val)
		{
			current = l1;
			current->next = recursive(l1->next, l2);
		}
		else
		{
			current = l2;
			current->next = recursive(l1, l2->next);
		}
		return current;
	}
};
```
```c++
//非递归
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
```
