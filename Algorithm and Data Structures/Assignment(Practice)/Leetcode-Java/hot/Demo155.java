package hot;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Demo155
{
    Deque<Integer> stack;
    Deque<Integer> minStack;


    public Demo155()
    {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x)
    {
        stack.push(x);
        //小于等于都存,一一对应,好删除
        if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
    }

    public void pop()
    {
        if(stack.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top()
    {
        if (stack.isEmpty()) throw new RuntimeException();
        return stack.peek();
    }

    public int getMin()
    {
        if (minStack.isEmpty()) throw new RuntimeException();
        return minStack.peek();
    }
}

