import java.util.*;

/**
 * Created by Osman Akkus on 20.04.2017.
 */
public class BinaryHeap<E extends Comparable<E>> extends BinaryTree<E> implements Queue<E>{

    /** The reference to implement heap offer and poll methods*/
    private LinkedList<E> theData;

    private boolean addReturn;

    // Constructor
    /** Construct a BinaryHeap with the given name.
     */
    public BinaryHeap() {
        theData = new LinkedList<>();
    }

    /***
     * This method calls the offer method to add new item into tree
     * @param time
     */
    public void addNewPassenger(int time){
        offer((E)new Passenger(time));
    }

    /**
     * Check the empty
     * @return true or false
     */
    public boolean isEmpty(){
        return theData.isEmpty();
    }

    /** Determine the size of the passenger queue
     @return the size of the passenger queue
     */
    public int size() {
        return theData.size();
    }

    /** Insert an item into the priority queue.
     pre: The ArrayList theData is in heap order.
     post: The item is in the priority queue and
     theData is in heap order.
     @param item The item to be inserted
     @throws NullPointerException if the item to be inserted is null.
     */
    public boolean offer(E item) {
        // Add the item to the heap.
        theData.add(item);
        // child is newly inserted item.
        int child = theData.size() - 1;
        int parent = (child - 1) / 2; // Find child’s parent.
        // Reheap
        while (parent >= 0 && compare(theData.get(parent),
                theData.get(child)) > 0) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        fillTheBinaryHeapTree();
        return true;
    }

    /**
     *Helper function
     * @param parent
     * @param child
     */
    private void swap(int parent, int child) {
        int temp;
        temp = parent;
        parent = child;
        child = temp;
    }

    /***
     * This fuction reads the all of the Linked List data and build tree
     */
    private  void  fillTheBinaryHeapTree(){
        int i = 0;
        root = null;
        while(i < theData.size()){
            add(theData.get(i));
            i++;
        }
        return;
    }

    /** Remove an item from the priority queue
     pre: The ArrayList theData is in heap order.
     post: Removed smallest item, theData is in heap order.
     @return The item with the smallest priority value or null if empty.
     */
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // Save the top of the heap.
        E result = theData.get(0);
        // If only one item then remove it.
        if (theData.size() == 1) {
            theData.remove(0);
            return result;
        }
    /* Remove the last item from the ArrayList and place it into
       the first position. */
        theData.set(0, theData.remove(theData.size() - 1));
        // The parent starts at the top.
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= theData.size()) {
                break; // Out of heap.
            }
            int rightChild = leftChild + 1;
            int minChild = leftChild; // Assume leftChild is smaller.
            // See whether rightChild is smaller.
            if (rightChild < theData.size()
                    && compare(theData.get(leftChild),
                    theData.get(rightChild)) > 0) {
                minChild = rightChild;
            }
            // assert: minChild is the index of the smaller child.
            // Move smaller child up heap if necessary.
            if (compare(theData.get(parent),
                    theData.get(minChild)) > 0) {
                swap(parent, minChild);
                parent = minChild;
            }
            else { // Heap property is restored.
                break;
            }
        }
        fillTheBinaryHeapTree();
        return result;
    }

    /**
     *Provided from book
     * Compare two items using either a Comparator object�s compare method
     * or their natural ordering using method compareTo.
     * @pre If comparator is null, left and right implement Comparable<E>.
     * @param left One item
     * @param right The other item
     * @return Negative int if left less than right,
     *         0 if left equals right,
     *         positive int if left > right
     * @throws ClassCastException if items are not Comparable
     */
    @SuppressWarnings("unchecked")
    private int compare(E left, E right) {
        return (left).compareTo(right);
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

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Binary heap tree according to processing time\n");
        /*for (int i = 0; i < theData.size(); i++) {
            builder.append(theData.get(i) + " ");
        }*/
        return builder.toString();
    }


    /*** Ignored Queue interface methods**/
    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
    }
}
