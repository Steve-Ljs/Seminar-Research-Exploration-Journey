```
给定链接列表，从列表末尾删除第n个节点并返回其头部。

例：

给定链表：1-> 2-> 3-> 4-> 5，n = 2。

从末尾删除第二个节点后，链表变为1-> 2-> 3-> 5。
注意：

给定n将始终有效。
```

```c++
struct ListNode
{
	int val;
	ListNode *next;
	ListNode(int x) :val(x), next(NULL) {}
};

class Solution
{
public:
	ListNode* removeNthFromEnd(ListNode* head, int n)
	{
		ListNode **t1 = &head, *t2 = head;//有效地利用二级指针，将其作为管理和操作链表的首要选项
		for (int i = 1; i != n; ++i)//使得t1与t2的间隔为链表尾部与删除目标的间隔
		{
			t2 = t2->next;
		}
		//我们通过同时移动两个指针向前来保持这个恒定的间隔，直到先走指针到达最后一个结点
		while (t2->next != NULL)
		{
			t1 = &((*t1)->next);
			t2 = t2->next;
		}
		*t1 = (*t1)->next;
		//此时t1就指向了要删除的节点了
		//不需要prev指针了，也不需要再去判断是否为链表头了，但是，t1变成了一个指向指针的指针
		//如果t1是表头,则表示head=head->next,成功
		//如果t1不是表头,则前一个指针指向*t1,*t1又指向了*t1之后的一个元素,相当于跳过了原本*t1的元素
		//保持（最后一个ListNode的（下一个字段）的地址））。因此，当我们停在当前的ListNode时，我们可以修改该地址中的内容以指向下一个ListNode。即删除当前的ListCode
		return head;
	}
};

```
