package demo51_100;

import java.util.Stack;

public class Demo55
{
    private Stack<Integer> stack;
    private Stack<Integer> minValue;

    public Demo55()
    {
        stack = new Stack<>();
        minValue = new Stack<>();
    }

    public void push(int x)
    {
        stack.push(x);
        if(minValue.empty() || minValue.peek()>=x)
        {
            minValue.push(x);
        }
    }

    public void pop()
    {
        //System.out.println(stack.peek()+"  "+minValue.peek());
        //if(stack.peek()==minValue.peek()) minValue.pop();
        if(stack.peek().equals(minValue.peek())) minValue.pop();
        stack.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return minValue.peek();
    }

    public static void main(String[] args)
    {
        Demo55 minStack = new Demo55();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
