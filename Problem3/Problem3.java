package Problem3;
// This problem was asked by Google.
// Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
// node = Node('root', Node('left', Node('left.left')), Node('right'))
// assert deserialize(serialize(node)).left.left.val == 'left.left'

public class Problem3{
    public static void main(String[] args) {
        Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
        String s1 = node.serialize(node);
        String s2 = node.serialize(node.deserialize(s1));
        System.out.println(s1.equals(s2));
    }

}