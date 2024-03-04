```
设计并实现最近最少使用（LRU）缓存的数据结构。它应该支持以下操作：get和put。
get(key) - 如果key存在于缓存中，则获取key的值（将始终为正），否则返回-1。
put(key, value) - 如果key尚不存在，则设置或插入值。当缓存达到其容量时，它应该在插入新项之前使最近最少使用的项无效。

跟进：
你能否在O（1）时间复杂度下进行这两项操作？

Example:
LRUCache cache = new LRUCache( 2 /* capacity */ );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```

```c++
struct Node 
{
	int _key,_value;
	Node * _next,* _prev;
	Node(int key, int value, Node* prev = NULL, Node* next = NULL) :_key(key), _value(value), _prev(prev), _next(next) {}
};

class LRUCache 
{
public:
	LRUCache(int capacity) :_capacity(capacity), _head(NULL), _tail(NULL) {}

	int get(int key) 
	{
		if (_nums.find(key) != _nums.end()) 
		{
			Node* currentNode = _nums[key];
			remove(currentNode);
			add(currentNode);
			return currentNode->_value;
		}
		return -1;
	}

	void put(int key, int value) 
	{
		if (_nums.find(key) != _nums.end()) 
		{
			Node* currentNode = _nums[key];
			currentNode->_value = value;
			remove(currentNode);
			add(currentNode);
		}
		else 
		{
			if (_nums.size() == _capacity) 
			{
				Node* nodeToRemove = _head;
				_nums.erase(nodeToRemove->_key);
				remove(_head);
			}
			Node* currentNode = new Node(key, value,_tail);
			if (_nums.size() == 0)
				_head = currentNode;
			else
				_tail->_next = currentNode;
			_tail = currentNode;
			_nums[key] = currentNode;
		}
	}

private:
	unordered_map<int, Node*> _nums;
	Node* _head,* _tail;
	int _capacity;
	void remove(Node* node) 
	{
		Node* prevNode = node->_prev;
		Node* nextNode = node->_next;
		node->_next = NULL;
		if (prevNode)
			prevNode->_next = nextNode;
		else
			_head = nextNode;

		if (nextNode)
			nextNode->_prev = prevNode;
		else
			_tail = prevNode;
	}
	void add(Node* node) 
	{
		if (_tail)
			_tail->_next = node;
		else
			_head = node;
		node->_prev = _tail;
		_tail = node;
	}
};
```


```c++
//写法简单,但速度慢
struct Node
{
	int key;
	Node* next ;
	Node(int x) :key(x), next(NULL) {}
};

class LRUCache 
{
public:
	LRUCache(int capacity) :_capacity(capacity) {}
	int get(int key) 
	{
		if (_map.find(key) != _map.end())
		{
			delete_it(key);
			add_it(key);
			return _map[key];
		}
		
			return -1;
	}

	void put(int key, int value) 
	{
		if (_map.find(key) != _map.end())
		{
			_map[key] = value;
			delete_it(key);
			add_it(key);
		}
		else if (_count < _capacity)
		{
			_map[key] = value;
			add_it(key);
			++_count;
		}
		else
		{
			_map.erase(_tail->key);
			delete_it(_tail->key);
			_map[key] = value;
			add_it(key);
		}
	}
private:
	unordered_map<int, int> _map;
	int _capacity;
	int _count = 0;
	Node* _head=NULL,*_tail=NULL;

	void delete_it(int key)
	{
		if (!_head->next)
		{
			_head = NULL;
			_tail = NULL;
			return;
		}
		if (_head->key == key)
		{
			Node* temp = _head;
			_head = _head->next;
			temp->next = NULL;
			return;
		}
		Node* pre = _head;
		while (pre->next->key != key)
		{
			pre = pre->next;
		}
		Node* temp = pre->next;
		pre->next = pre->next->next;
		temp->next = NULL;
		if (!pre->next)
			_tail = pre;
	}
	void add_it(int key)
	{
		if (!_head)
		{
			_head = new Node(key);
			_tail = _head;
		}
		else
		{
			Node* node = new Node(key);
			node->next = _head;
			_head = node;
		}
	}
};
```
