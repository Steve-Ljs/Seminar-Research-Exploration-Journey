```
设计一个支持push，pop，top和在恒定时间内检索最小元素的堆栈。

push（x） - 将元素x推入堆栈。
pop（） - 删除堆栈顶部的元素。
top（） - 获取顶部元素。
getMin（） - 检索堆栈中的最小元素。
例：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

```c++
class MinStack 
{
private:
	stack<int> s1,s2;//s2只存越来越小的,保证积在s1前面的值始终很小
public:
	void push(int x) 
	{
		s1.push(x);
		if (s2.empty() || x <= getMin())
			s2.push(x);
	}
	void pop() 
	{
		if (s1.top() == getMin())
			s2.pop();
		s1.pop();
	}
	int top() 
	{
		return s1.top();
	}
	int getMin() 
	{
		return s2.top();
	}
};
```
