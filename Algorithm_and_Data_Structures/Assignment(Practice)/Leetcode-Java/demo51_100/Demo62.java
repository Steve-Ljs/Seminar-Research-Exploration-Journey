package demo51_100;




public class Demo62
{

    class TreeNode
    {
        boolean val;
        TreeNode[] next = new TreeNode[26];
    }

    private TreeNode root;

    public Demo62()
    {
        root=new TreeNode();
    }

    public void insert(String word)
    {
        TreeNode temp = root;
        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(temp.next[index]==null) temp.next[index]=new TreeNode();//这一步至关重要,没有判断,那么后面的会覆盖前面的
            temp = temp.next[index];
        }
        temp.val = true;
    }

    public boolean search(String word)
    {
        TreeNode temp = root;
        for (int i = 0; i < word.length(); i++)
        {
            if(temp==null)
            {
                return false;
            }
            int index = word.charAt(i) - 'a';
            temp = temp.next[index];
        }
        if(temp==null) return false;
        else return temp.val;
    }

    public boolean startsWith(String prefix)
    {
        TreeNode temp = root;
        for (int i = 0; i < prefix.length(); i++)
        {
            if(temp==null) return false;
            int index = prefix.charAt(i) - 'a';
            temp = temp.next[index];
        }
        if(temp==null) return false;
        else return true;
    }

    public static void main(String[] args)
    {
        Demo62 trie = new Demo62();

        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apple"));
//        //trie.search("apple");   // 返回 true
//        System.out.println(trie.search("app"));//trie.search("app");     // 返回 false
//        System.out.println(trie.startsWith("app"));//trie.startsWith("app"); // 返回 true
//        System.out.println(trie.search("app"));//trie.search("app");     // 返回 true
    }
}
