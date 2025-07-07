class Solution {

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> copy = new HashMap();
        Queue<Node> q = new LinkedList();

        q.add(node);
        copy.put(node, new Node(node.val));
        
        while(!q.isEmpty()) {
            Node polled = q.poll();

            for(Node n: polled.neighbors) {
                if(!copy.containsKey(n)) {
                    copy.put(n, new Node(n.val));
                    q.add(n);
                }

                copy.get(polled).neighbors.add(copy.get(n));
            }
        }

        return copy.get(node);
    }
}
