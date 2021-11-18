package Problem3;

import java.util.ArrayList;

public class Node {
    private String val;
    private Node left;
    private Node right;

    // Given
    public Node(String val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    // Given
    public Node(String val, Node left){
        this.val = val;
        this.left = left;
        this.right = null;
    }
    // Given
    public Node(String val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private ArrayList<String> serializer (ArrayList<String> values, Node node){
        if (node == null) {
            values.add("?");
        } else {
            values.add(node.val);
            serializer(values, node.left);
            serializer(values, node.right);
        }
        return values;
    }
    public String serialize(Node node){
        ArrayList<String> values = new ArrayList<>();
        values = serializer(values, node);
        return values.toString().replace("[", "").replace("]", "");
    }

    public Node deserialize(String tree){
        String[] values = tree.split(", ");
        return deserializer(values, 0);
    }
    private Node deserializer(String[] values, int index){
        String val = values[index];
        if (val.equals("?")){
            return null;
        } else {
            Node node = new Node(val);
            node.left = deserializer(values, ++index);
            node.right = deserializer(values, ++index);
            return node;
        }
    }
}
