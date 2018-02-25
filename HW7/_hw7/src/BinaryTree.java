import java.io.*;
import java.util.Map;

/** Class for a binary tree that stores type E objects.
 *   @author Koffman and Wolfgang
 * */

public class BinaryTree <K extends Comparable<K>,V> implements Serializable {

    /** Class to encapsulate a tree node. */
    protected static class Node <K extends Comparable<K>,V> implements Serializable, Map.Entry<K,V>{

        // Data Fields
        /** The information stored in this node. */
        protected K key;

        protected V value;

        /** Reference to the left child. */
        protected Node <K,V> left;

        /** Reference to the right child. */
        protected Node <K,V> right;

        /**
         *
         * @param key
         * @param value
         */
        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }


        /** Return a string representation of the node.
         @return A string representation of the data fields
         */
        public String toString() {
            return "\n" + key.toString() + "," + value.toString() + "\n";
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V v) {
            return null;
        }
    }

    // Data Field
    /** The root of the binary tree */
    protected Node <K,V> root;

    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node <K,V> root) {
        this.root = root;
    }

    /** Constructs a new binary tree with data in its root,leftTree
     as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(K key,V value, BinaryTree <K,V> leftTree,BinaryTree <K,V> rightTree) {

        root = new Node <K,V> (key,value);

        if (leftTree != null) {
            root.left = leftTree.root;
        }
        else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
        else {
            root.right = null;
        }
    }

    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinaryTree < K,V> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree <K,V> (root.left);
        }
        else {
            return null;
        }
    }

    /** Return the right sub-tree
     @return the right sub-tree or
     null if either the root or the
     right subtree is null.
     */
    public BinaryTree<K,V> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<K,V>(root.right);
        } else {
            return null;
        }
    }

    /** Determine whether this tree is a leaf.
     @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /** Perform a preorder traversal.
     @param node The local root
     @param depth The depth
     @param sb The string buffer to save the output
     */
    public void preOrderTraverse(Node <K,V> node, int depth, StringBuilder sb) {
        if(node != null){
            sb.append(node.toString());
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
}
