import java.util.LinkedList;

/**
 * Created by otto on 22.03.2017.
 */
public class myQueue<E> extends  KWLinkedList<E>{


    /**
     * No parameter constructor
     */
    public  myQueue(){/*intentionally empty*/}

    /**
     *Adds a new value
     * @return
     */
    public boolean offer(E item){
        addLast(item);
        return  true;
    }

    /**
     * This function reverse the line iteratively
     * @return
     */
    public String reverseIterative(){
        myQueue<E> other = new myQueue<E>();
        for (int i = 0; i < size(); i++) {
            E item = remove();
            other.addFirst(item);
            addLast(item);
        }
        return other.toString();
    }

    /**
     * Thisr takes a parameter and reverse it recursively
     *
     * @param other
     * @return
     */
    public String reverseRecursively(myQueue other){

        if (size() == 0)
            return "";
        E item = (E) other.remove();
        reverseRecursively(other);

        other.addLast(item);

        return toString();
    }
    /**
     *toString method
     * @return
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(size()).append(" :");
        for (int i = 0; i < size(); i++) {
            builder.append(get(i));
            if (i != size() -1)
                builder.append(",");
        }
        builder.append("\n");

        return builder.toString();
    }
}
