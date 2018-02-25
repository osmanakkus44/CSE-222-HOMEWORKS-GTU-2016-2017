import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by Osman Akkus on 24.03.2017.
 */
public class PriorityQueue2<E> {

    LinkedList<E> instance = null;

    /**
     * No parameter constructor
     */
    public PriorityQueue2(){
        instance = new LinkedList<E>();
    }


    /**
     * Returns the size of list
     * @return size
     */
    public int size(){
        return instance.size();
    }


    /**
     * Check the empty
     * @return true or false
     */
    public boolean isEmpty(){
        return instance.isEmpty();
    }

    /** An optional reference to a Comparator object. */
    Comparator<E> comparator = null;

    /**
     * This function taken from book and it is generated for the LinkedList by me
     * Insert an item into the priority queue.
     * @param item The item to be inserted
     * @throws NullPointerException if the item to be inserted is null.
     */

    public boolean offer(E item) {
        instance.add(item);
        // child is newly inserted item.
        int child = size() - 1;
        int parent = (child - 1) / 2; // Find child�s parent.
        // Reheap
        while (parent >= 0 && compare(instance.get(parent),instance.get(child)) > 0) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
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


    /**
     * This method is generated from books poll method by me
     * Remove an item from the priority queue
     * @result Removed smallest item
     * @return The item with the smallest priority value or null if empty.
     */
    public E deleteMin() {
        if (isEmpty()) {
            return null;
        }
        // Save the top of the heap.
        E result = instance.get(0);
        // If only one item then remove it.
        if (size() == 1) {
            instance.remove(0);
            return result;
        }
        // Remove the last item from the ArrayList and place it into
        // the first position.
        instance.set(0, instance.remove(size() - 1));
        // The parent starts at the top.
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= size()) {
                break; // Out of heap.
            }
            int rightChild = leftChild + 1;
            int minChild = leftChild; // Assume leftChild is smaller.
            // See whether rightChild is smaller.
            if (rightChild < size() && compare(instance.get(leftChild),
                    instance.get(rightChild)) > 0) {
                minChild = rightChild;
            }
            // assert: minChild is the index of the smaller child.
            // Move smaller child up heap if necessary.
            if (compare(instance.get(parent),
                    instance.get(minChild)) > 0) {
                swap(parent, minChild);
                parent = minChild;
            } else { // Heap property is restored.
                break;
            }
        }
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
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(left, right);
        } else { // Use left�s compareTo method.
            return ((Comparable<E>) left).compareTo(right);
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append("PriorityQueue2 : ");

        return builder.toString() + instance.toString();
    }
}
