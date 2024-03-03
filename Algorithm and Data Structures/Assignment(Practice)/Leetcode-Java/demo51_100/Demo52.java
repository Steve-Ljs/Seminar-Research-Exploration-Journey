package demo51_100;

import java.util.LinkedHashMap;
import java.util.Map;

/*
下面自己写的实现就是LinkedHashMap的简单实现原理

LinkedHashMap<Integer, Integer>
它是一个将所有Entry节点链入一个双向链表的HashMap
此外，LinkedHashMap可以很好的支持LRU算法
它额外维护了一个双向链表用于保持迭代顺序,该迭代顺序可以是插入顺序，也可以是访问顺序。
 */
public class Demo52 extends LinkedHashMap<Integer,Integer>
{
    private int capacity;
    /*
    当accessOrder标志位为true时，表示双向链表中的元素按照访问的先后顺序排列
    当标志位accessOrder的值为false时，表示双向链表中的元素按照Entry插入LinkedHashMap到中的先后顺序排序
    当我们要用LinkedHashMap实现LRU算法时，就需要调用该构造方法并将accessOrder置为true。
    当accessOrder为true时，get方法和put方法都会调用recordAccess方法使得最近使用的Entry移到双向链表的末尾
     */
    public Demo52(int capacity)
    {
        super(capacity,0.75F, true);
        this.capacity = capacity;
    }
    public int get(int key)
    {
        return super.getOrDefault(key, -1);
    }

    public void put(int key,int value)
    {
        super.put(key, value);
    }

    /*
    该方法是用来被重写的，一般地，如果用LinkedHashMap实现LRU算法，就要重写该方法。
    比如可以将该方法覆写为如果设定的内存已满，则返回true，
    这样当再次向LinkedHashMap中putEntry时，
    在调用的addEntry方法中便会将近期最少使用的节点删除掉（header后的那个节点）。
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
    {
        return size()>capacity;
    }
}

/*
自己写的LRU算法
LRU 的全称是 Least Recently Used,最近最少使用
核心数据结构就是哈希链表，双向链表和哈希表的结合体
链表:插入O(1),双向链表:删除任意一个节点O(1)
 */
/*
public class LRUCache
{
    //节点
    private class Node
    {
        int key,val;
        Node next, prev;

        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    //双向链表
    private class DoubleList
    {
        private Node head,tail;//头尾虚节点
        private int size;

        public DoubleList()
        {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node x)
        {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            ++size;
        }

        public void remove(Node x)
        {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            --size;
        }

        public Node removeLast()
        {
            if(tail.prev==head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size()
        {
            return size;
        }
    }


    //通过key查询得到相应的Node(O(1)),再删除Node(在双向链表中的操作也是O(1)),

    private int capacity;
    private HashMap<Integer, Node> map;//因为key就是int类型的
    private DoubleList cache;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public void put(int key, int val)
    {
        Node temp = new Node(key, val);
        if(map.containsKey(key))
        {
            cache.remove(map.get(key));
            cache.addFirst(temp);
            map.put(key, temp);//因为前后链接变了,要更新
        }
        else
        {
            if(capacity==cache.size)
            {
                Node last = cache.removeLast();
                map.remove(last.key);//这是为什么Node要存key,val,不能只存val
            }
            cache.addFirst(temp);
            map.put(key, temp);
        }
    }

    public int get(int key)
    {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key,val);//变成最新的了
        return val;
    }
}
*/
