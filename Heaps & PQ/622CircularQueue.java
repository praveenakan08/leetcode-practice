class MyCircularQueue {

    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private int totalCapacity;

    private int currentCapacity;

    private Node head;

    private Node tail;

    public MyCircularQueue(int k) {
        head = new Node(-1);
        tail = new Node(-1);

        head.prev = tail;
        head.next = tail;

        tail.prev = head;
        tail.next = head;

        totalCapacity = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }

        Node newNode = new Node(value);

        Node temp = head.prev;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = head;
        head.prev = newNode;

        currentCapacity++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }

        Node left = tail;
        Node right = tail.next.next;
        
        left.next = right;
        right.prev = left;
        
        currentCapacity--;
        return true;
    }
    
    public int Front() {
        if(currentCapacity <= 0) {
            return -1;
        }

        return tail.next.val;
    }
    
    public int Rear() {
        if(currentCapacity <= 0) {
            return -1;
        }

        return head.prev.val;
    }
    
    public boolean isEmpty() {
        if(currentCapacity == 0) {
            return true;
        } 

        return false;
    }
    
    public boolean isFull() {
        if(currentCapacity >= totalCapacity) {
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */