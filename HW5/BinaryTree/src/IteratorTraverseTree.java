import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * It has methods to read elements from file and preorder
 * traverse the tree using iterator
 *
 * Created by Osman Akkus on 02.04.2017.
 */
public class IteratorTraverseTree <E extends Comparable<E>> extends BinaryTree<E> implements Iterable<E>{

    private Node<E> root;
    //Check add method
    private boolean addReturn;

    //List object to keep datas
    private ArrayList<Node> myData;

    /**
     * No parameter constructor
     */
    public IteratorTraverseTree(){
        root = null;
        myData = new ArrayList<>();
    }

    /**
     * Overridden iterator method of the Iterable interface
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIter();
    }

    /**
     * ToString method of the BinarySearchTree
     * @return
     */
    @Override
    public String toString(){

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
     * This inner class implements Iterator interface
     * This provides us to travel on the items of the Tree
     * @param <E>
     */
    private class MyIter<E> implements Iterator<E>{

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

    /**
     * By the this function we read the items one by one with Scanner objects
     * and add to the tree
     * @param fileName
     * @throws IOException
     */
    public void readFile(String fileName) throws IOException {

        File file = new File(fileName);
        Object data;
        Scanner scan = new Scanner(file);

        while (scan.hasNextInt()){
            data =  scan.nextInt();
            add((E) data);
        }
    }

    /**
     *
     * Starter method add.
     * @pre The object to insert must implement the
     *      Comparable interface.
     * @param item The object being inserted
     * @return true if the object is inserted, false
     *         if the object already exists in the tree
     */

    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    /**
     * Recursive add method.
     * @post The data field addReturn is set true if the item is added to
     *       the tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the
     *         inserted item
     */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node<E>(item);
        }
        else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        }
        else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        // item is greater than localRoot.data
        localRoot.right = add(localRoot.right, item);
        return localRoot;
    }
}
