```
给定链表，返回循环开始的节点。如果没有循环，则返回null。

为了表示给定链表中的循环，我们使用一个整数pos来表示tail连接到的链表中的位置（0索引）。如果pos是-1，那么链表中没有循环。

注意：请勿修改链接列表。

例1：
输入： head = [3,2,0，-4]，pos = 1
 输出： tail连接到节点索引1
 说明：链表中有一个循环，其中tail连接到第二个节点。

例2：
输入： head = [1,2]，pos = 0
 输出： tail连接到节点索引0
 说明：链表中有一个循环，其中tail连接到第一个节点。

例3：
输入： head = [1]，pos = -1
 输出：无循环
 说明：链表中没有循环。

跟进：
你能不用额外的空间解决它吗？
```

```c++
class Solution 
{
public:
	ListNode* detectCycle(ListNode* head) 
	{
		if (head == NULL || head->next == NULL)
			return NULL;
		ListNode * slow = head;
		ListNode * fast = head;
		ListNode * entry = head;

		while (fast->next && fast->next->next) 
		{
			slow = slow->next;
			fast = fast->next->next;
			if (slow == fast) //确定是否存在循环
			{                      
				while (slow != entry) //如果有循环，则返回循环的输入位置
				{               
					//slow:L1+L2  fast:L1+L2+x+L2  fast=2slow  L1=x
					//头部位置和进入位置之间的距离等于会合位置和沿着向前移动方向的进入位置之间的距离。
					slow = slow->next;
					entry = entry->next;
				}
				return entry;
			}
		}
		return NULL;                                
	}
};
```
