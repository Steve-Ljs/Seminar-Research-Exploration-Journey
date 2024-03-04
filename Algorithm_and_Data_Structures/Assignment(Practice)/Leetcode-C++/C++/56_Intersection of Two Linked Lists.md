```
编写程序以找到两个单链表开头的节点。
例如，以下两个链表：
开始在节点c1处相交。

例1：
输入： intersectVal = 8，listA = [4,1,8,4,5]，listB = [5,0,1,8,4,5]，skipA = 2，skipB = 3
 输出：节点的参考value = 8
 输入说明：相交节点的值为8（请注意，如果两个列表相交，则此值不能为0）。从A的头部开始，它的内容为[4,1,8,4,5]。从B的头部看，它的内容为[5,0,1,8,4,5]。在A中的交叉节点之前有2个节点; 在B中的交叉节点之前有3个节点。

例2：
输入： intersectVal = 2，listA = [0,9,1,2,4]，listB = [3,2,4]，skipA = 3，skipB = 1
 输出：值为2的节点的引用
 输入说明：  相交节点的值为2（请注意，如果两个列表相交，则此值不能为0）。从A的头部，它读作[0,9,1,2,4]。从B的头部看，它的内容为[3,2,4]。在A中的交叉节点之前有3个节点; 在B中的交叉节点之前有1个节点。

例3：
输入： intersectVal = 0，listA = [2,6,4]，listB = [1,5]，skipA = 3，skipB = 2
 输出： null
 输入说明：从A的头部，它读作[2,6] ，4]。从B的头部看，它的内容为[1,5]。由于两个列表不相交，因此intersectVal必须为0，而skipA和skipB可以是任意值。
说明：两个列表不相交，因此返回null。

笔记：
如果两个链接列表根本没有交集，则返回null。
函数返回后，链接列表必须保留其原始结构。
您可以假设整个链接结构中没有任何循环。
您的代码最好在O（n）时间内运行，并且只使用O（1）内存。
```

```c++
class Solution
{
public:
	ListNode* getIntersectionNode(ListNode* headA, ListNode* headB)
	{
		if (!headA || !headB) return NULL;
		ListNode* p1 = headA, * p2 = headB;
		while (p1!=p2) //多走一个来回,这样两者走的路程将一样
		{
			p1 = p1->next;
			p2 = p2->next;
			if (p1 == p2) return p1;//要不再相交点相遇,要不再NULL处相遇
			if (!p1) p1 = headB;//交换走,保证路程一样
			if (!p2) p2 = headA;
		}
		return p1;
	}
};
```
