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
// TC - O(n), SC - O(n)
class Solution {
    public Node copyRandomList(Node head) {
        // key: origNode -> val: newNode
        Map<Node, Node> map = new HashMap();
        Node current = head;

        // creating copies of nodes
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        // adding pointers
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }
}
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

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();

        Node temp = head;
        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            map.get(temp).next = map.get(temp.next); // getting new dummy node
            map.get(temp).random = map.get(temp.random); 

            temp = temp.next;
        }

        return map.get(head);
    }
}