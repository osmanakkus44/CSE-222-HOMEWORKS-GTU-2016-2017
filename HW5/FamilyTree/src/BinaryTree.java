import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/*
 *This class provided from Book
 * But has a lot new methods written by me
 * Class for a binary tree that stores type E objects.
 *   @author Koffman and Wolfgang
 */

public class BinaryTree <E> implements Serializable {

    /** Class to encapsulate a tree node. */
    protected static class Node <E> implements Serializable {

        // Data Fields
        /** The information stored in this node. */
        protected E data;

        /** Reference to the left child. */
        protected Node <E> left;

        /** Reference to the right child. */
        protected Node <E> right;


        // Constructors
        /** Construct a node with given data and no children.
         @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        /** Return a string representation of the node.
         @return A string representation of the data fields
         */
        public String toString() {
            return data.toString();
        }

    }

    public Iterator<E> iterator(){
        return new MyIter<>();
    }

    /**
     * This inner class implements Iterator interface
     * This provides us to travel on the items of the Tree
     * @param <E>
     */
    protected class MyIter<E> implements Iterator<E> {

        //The next item to do not lose the root reference
        private Node nextItem;

        /**
         * My Iterator class's constructor to init nextItem
         * to root and fill the ArrayList
         */
        public MyIter(){
            nextItem = root;
            fillTheList(nextItem);
        }

        /**
         * Overridden hasNext function to check whether the
         * have data or not
         * @return
         */
        @Override
        public boolean hasNext() {
            return (!myData.isEmpty());
        }

        /**
         *Give the next item
         * @return
         */
        @Override
        public E next() {
            if(hasNext()){
                nextItem = myData.remove(0);
                return (E) nextItem.data;
            }
            return null;
        }

        /**
         * This function takes node(root) and
         * fill the ArrayList to use later
         * @param node
         * @return true if success false is not
         */
        private boolean fillTheList(Node node){
            if (node == null)
                return false;
            else {
                myData.add(node);
                fillTheList(node.left);
                fillTheList(node.right);
            }
            return true;
        }
        /**
         *This function takes a node , depth and StringBuilder paramater
         * and generate String obj using preOrderTraverse rule by Iterator functions
         * @param node given node most probably root
         * @param sb
         */
        private void preOrderTraverseIterator(Node <E> node, StringBuilder sb) {
            E temp;
            while(hasNext()){
                temp = next();
                sb.append(temp.toString() + "  ");
            }
        }
    }

    // Data Field
    /** The root of the binary tree */
    private Node <E> root;

    /*List structure to keep nodes*/
    private ArrayList<Node> myData;

    /**
     * No parameter Constructor
     */
    public BinaryTree() {
        myData = new ArrayList<>();
        root = null;
    }

    /**
     *Constructor with a node parameter
     * @param root
     */
    protected BinaryTree(Node <E> root) {
        myData = new ArrayList<>();
        this.root = root;
    }

    /** Constructs a new binary tree with data in its root,leftTree
     as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree <E> leftTree,BinaryTree <E> rightTree) {

        root = new Node <E> (data);

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
    public BinaryTree <E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree <E> (root.left);
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
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
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
        StringBuilder builder = new StringBuilder();
        MyIter<E> iter = new MyIter<>();

        builder.append("My Iterator preOrderTraverse Printing: \n");
        iter.preOrderTraverseIterator(root,builder);

        builder.append("\n");

        builder.append("\nExtended BinaryTree preOrderTraverse Printing: \n");
        preOrderTraverse(root,1,builder);

        return builder.toString();
    }

    /**
     * Perform a preorder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    public void preOrderTraverse(Node < E > node, int depth,
                                 StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        }
        else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /** Method to read a binary tree.
     pre: The input consists of a preorder traversal
     of the binary tree. The line "null" indicates a null tree.
     @param bR The input file
     @return The binary tree
     @throws IOException If there is an input error
     */
    public BinaryTree <String>
    readBinaryTree(BufferedReader bR) throws IOException {
        // Read a line and trim leading and trailing spaces.
        String data;
        if (( data = bR.readLine().trim()) == null) {
            return null;
        }
        else {
            BinaryTree <String> leftTree = readBinaryTree(bR);
            BinaryTree <String> rightTree = readBinaryTree(bR);
            return new BinaryTree <String> (data, leftTree, rightTree);
        }
    }

}
