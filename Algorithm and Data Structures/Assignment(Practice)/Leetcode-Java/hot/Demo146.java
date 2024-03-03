package hot;

import java.util.*;


public class Demo146
{
    private Map<Integer, Node> map;//存储的是key,Node
    DoubleList cache;//用于保证删除是O(1)
    private int capacity;

    private class Node
    {
        int key;
        int value;
        Node next;
        Node pre;

        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private class DoubleList
    {
        Node first;//头尾虚节点
        Node last;
        int size;

        DoubleList()
        {
            first = new Node(0, 0);
            last = new Node(0, 0);
            first.next = last;
            last.pre = first;
            size = 0;
        }

        void addFirst(Node node)
        {
            node.pre=first;
            node.next=first.next;
            first.next.pre=node;
            first.next=node;
            ++size;
        }

        Node remove(Node node)
        {

            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = null;
            node.next = null;

            --size;

            return node;
        }

        Node removeLast()
        {
            if(size==0) return null;
            return remove(last.pre);
        }


    }

    public Demo146(int capacity)
    {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if (!map.containsKey(key)) return -1;
        int value = map.get(key).value;
        put(key, value);
        return value;
    }

    public void put(int key, int value)
    {
        Node node = new Node(key, value);
        if (map.containsKey(key))
        {
            cache.remove(map.get(key));
            cache.addFirst(node);
        }
        else
        {
            if (capacity == cache.size)
            {
                Node last = cache.removeLast();
                map.remove(last.key);//这是为什么Node要存key,val,不能只存val
            }
            cache.addFirst(node);
        }
        map.put(key, node);
    }
}

/**
 * 下面自己写的实现就是LinkedHashMap的简单实现原理
 * <p>
 * LinkedHashMap<Integer, Integer>
 * 它是一个将所有Entry节点链入一个双向链表的HashMap
 * 此外，LinkedHashMap可以很好的支持LRU算法
 * 它额外维护了一个双向链表用于保持迭代顺序,该迭代顺序可以是插入顺序，也可以是访问顺序。
 *
 * @author 12549
 */
/*public class LRUCache extends LinkedHashMap<Integer, Integer>
{
    private Integer capacity;

//    当accessOrder标志位为true时，表示双向链表中的元素按照访问的先后顺序排列
//    当标志位accessOrder的值为false时，表示双向链表中的元素按照Entry插入LinkedHashMap到中的先后顺序排序
//    当我们要用LinkedHashMap实现LRU算法时，就需要调用该构造方法并将accessOrder置为true。
//    当accessOrder为true时，get方法和put方法都会调用recordAccess方法使得最近使用的Entry移到双向链表的末尾

    public LRUCache(int capacity)
    {
        super(capacity,0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key)
    {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value)
    {
        super.put(key, value);
    }


//    该方法是用来被重写的，一般地，如果用LinkedHashMap实现LRU算法，就要重写该方法。
//    比如可以将该方法覆写为如果设定的内存已满，则返回true，
//    这样当再次向LinkedHashMap中putEntry时，
//    在调用的addEntry方法中便会将近期最少使用的节点删除掉（header后的那个节点）。

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
    {
        return size()>capacity;
    }
}*/
