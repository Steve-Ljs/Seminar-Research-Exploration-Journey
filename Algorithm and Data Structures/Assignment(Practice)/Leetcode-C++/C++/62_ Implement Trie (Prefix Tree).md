```
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
```
```c++
struct Node
{
	bool word;
	Node* next[26];
	Node() : word(false) 
	{ 
		memset(next, 0, sizeof(next)); //void *memset(void *s, char ch, unsigned n);
		//将s所指向的某一块内存中的每个字节的内容全部设置为ch指定的ASCII值	
	}
};
class Trie
{
public:
	Trie()
	{
		root = new Node();
	}

	void insert(string word)
	{
		Node * current = root;
		for (auto letter : word)
		{
			current = current->next[letter - 'a'] == nullptr ?
				current->next[letter - 'a'] = new Node() :current->next[letter - 'a'];
		}
		current->word = true;
	}

	bool search(string word)
	{
		Node * current = root;
		for (auto letter : word)
		{
			current = current->next[letter - 'a'];
			if (current == nullptr)
				return false;
		}
		return current->word;
	}

	bool startsWith(string prefix)
	{
		Node * current = root;
		for (auto letter : prefix)
		{
			current = current->next[letter - 'a'];
			if (current == nullptr)
				return false;
		}
		return true;
	}
private:
	Node* root;
};
```
