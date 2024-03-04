package offer;


import java.util.Stack;

public class Demo09 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //始终往stack1中添加元素
        stack1.push(node);
    }

    public int pop() {
        //始终从stack2中取出元素,如果为空,则把stack1的颠倒过来
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (stack1.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
