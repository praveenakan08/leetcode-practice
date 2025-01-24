/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// TC - O(n), SC - O(1)
class Solution {
    public Node copyRandomList(Node head) {
        // key: origNode -> val: newNode
        Map<Node, Node> map = new HashMap();
        Node current = head;

        // creating copies of nodes
        while(current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        // adding pointers
        while(current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }
}