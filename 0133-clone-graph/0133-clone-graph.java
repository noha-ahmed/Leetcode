/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return cloneGraphRec(node, new HashMap<>());
    }
    
    private Node cloneGraphRec(Node node, HashMap<Integer, Node> map){
        
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        List<Node> neighbors = new ArrayList<>(node.neighbors.size());
        for(Node neighbor : node.neighbors){
            if(!map.containsKey(neighbor.val))
                cloneGraphRec(neighbor, map);
            neighbors.add(map.get(neighbor.val));   
        }
        newNode.neighbors = neighbors;
        return newNode;
    }
}