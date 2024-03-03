```
链表不是很熟练,之后还是要练习,最基本的链表操作
自己写的太麻烦,主要是用了l1.next!=NUll;这样考虑情况太多了
直接用l1!=0,就是if(l1),然后用 l1=l1? l1->next:l1;等分情况讨论就行了
```

```c++
ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) 
{
    ListNode preHead(0), *p = &preHead;
    int extra = 0;
    while (l1 || l2 || extra) 
	  {
        int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + extra;//两个数再加上进位的数
        extra = sum / 10;
        p->next = new ListNode(sum % 10);
        p = p->next;
        l1 = l1 ? l1->next : l1;//如果l1不为空,就取l1的下一个链表元素
        l2 = l2 ? l2->next : l2;
    }
    return preHead.next;
}
```
