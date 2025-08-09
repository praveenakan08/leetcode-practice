class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public Node(int key, int val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;

    }
}
class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node left, right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            this.remove(node);
            this.insert(node);
            
            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int val) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node node = new Node(key, val);
        cache.put(key, node);

        insert(node);

        if(this.cache.size() > this.capacity) {
            Node lruNode = this.left.next;

            this.remove(lruNode);
            this.cache.remove(lruNode.key);    
        }

    }

    private void insert(Node node) {
        Node rightPrev = this.right.prev;
        this.right.prev = node;
        rightPrev.next = node;

        node.prev = rightPrev;
        node.next = this.right;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */