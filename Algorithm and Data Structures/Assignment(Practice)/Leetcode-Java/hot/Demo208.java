package hot;

public class Demo208
{
    private Node root;

    private class Node
    {
        int value;
        Node [] next;

        public Node()
        {
            this.value = -1;
            this.next = new Node[26];
        }
    }
    public Demo208()
    {
        root = new Node();
    }

    public void insert(String word)
    {
        Node temp = root;
        for (char ch : word.toCharArray())
        {
            int index = ch - 'a';
            if(temp.next[index]==null) temp.next[index] = new Node();
            temp = temp.next[index];
        }
        temp.value = 1;
    }

    public boolean search(String word)
    {
        Node temp = root;
        for (char ch : word.toCharArray())
        {
            int index = ch - 'a';
            if(temp.next[index]==null) return false;
            temp = temp.next[index];
        }
        return temp.value == 1;
    }

    public boolean startsWith(String prefix)
    {
        Node temp = root;
        for (char ch : prefix.toCharArray())
        {
            int index = ch - 'a';
            if(temp.next[index]==null) return false;
            temp = temp.next[index];
        }
        return true;
    }
}
