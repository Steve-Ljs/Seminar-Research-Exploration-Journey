package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Demo30 {
    class MinStack {

//两个栈,一个处理正常逻辑,一个存储最小值
//如果最小栈为空,则加入栈,否则比较put的元素和栈顶元素的大小,如果小于等于则存储
//minStack中存储的是递增序列
//弹出栈时,检查最小栈的栈顶元素

        private Deque<Integer> stack, minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            if (minStack.isEmpty()) {
                minStack.push(x);
            }
            else {
                if (minStack.peek() >= x) {
                    minStack.push(x);
                }
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }
            int result = stack.pop();
            if (!minStack.isEmpty() && minStack.peek() == result) {
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }
            return stack.peek();
        }

        public int min() {
            if (minStack.isEmpty()) {
                throw new NoSuchElementException();
            }
            return minStack.peek();
        }
    }
}
