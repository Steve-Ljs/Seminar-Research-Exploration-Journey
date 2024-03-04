```
给定一个链表，确定它是否有一个循环。
为了表示给定链表中的循环，我们使用一个整数pos来表示tail连接到的链表中的位置（0索引）。如果pos是-1，那么链表中没有循环。

例1：
输入： head = [3,2,0，-4]，pos = 1 
输出：true
 说明：链表中有一个循环，其中tail连接到第二个节点。

例2：
输入： head = [1,2]，pos = 0 
输出：true
 说明：链表中有一个循环，其中tail连接到第一个节点。

例3：
输入： head = [1]，pos = -1 
输出：false
 说明：链表中没有循环。
 
你能用O（1）（即常数）内存来解决它吗？
```

```c++
class Solution 
{
public:
	bool hasCycle(ListNode* head) 
	{
		//Use two pointers,slow moves step by step.fast moves two steps at time.
		//if the Linked List has a cycle fast and slow will meet at some point
		ListNode* fast = head;
		ListNode* slow = head;
		while (fast != nullptr) 
		{
			fast = fast->next;
			if (fast == nullptr) 
				return false;
			else 
				fast = fast->next;
			slow = slow->next;
			if (fast == slow) 
				return true;
		}
		return false;
	}
};
```
