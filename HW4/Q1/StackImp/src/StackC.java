import java.util.EmptyStackException;

/**
 * Created by otto on 21.03.2017.
 */
public class StackC<E> implements StackInterface<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        // Data Fields

        /** The reference to the data. */
        private E data;
        /** The reference to the next node. */
        private Node<E> next;

        // Constructors
        /**
         * Creates a new node with a null next field.
         * @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         * @param dataItem The data stored
         * @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    /**
     *No parameter constructor to instantiate
     * the data members
     */
    public StackC(){
        size = 0;
        head = null;
    }

    /**
     *Adds new obj into the stack
     * @param obj
     * @return
     */
    @Override
    public E push(E obj) {
        head = new Node<E>(obj,head);
        size++;
        return obj;
    }

    /**
     *
     * @return
     */
    @Override
    public E pop() {
        if (isEmpty()){
            throw  new EmptyStackException();
        }
        else {
            E obj = head.data;
            head = head.next;
            size--;
            return obj;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (head == null || size <= 0){
            return  true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @return size of stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("StackC " + size() + ": ");

        return  builder.toString();
    }
}
