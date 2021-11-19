package Problem3;

import java.util.ArrayList;
import java.util.Arrays;

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
            values.add("null");
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
        ArrayList<String> values = new ArrayList<String>(Arrays.asList(tree.split(", ")));
        return deserializer(values);
    }
    private Node deserializer(ArrayList<String> values){
        String val = values.remove(0);
        if (val.equals("null")){
            return null;
        } else {
            Node node = new Node(val);
            node.left = deserializer(values);
            node.right = deserializer(values);
            return node;
        }
    }
}
