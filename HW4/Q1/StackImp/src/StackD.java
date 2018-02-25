import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by otto on 21.03.2017.
 */
public class StackD<E> implements StackInterface<E>{

    Queue<E> instance = new LinkedList<E>();

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public E push(E obj) {
        instance.add(obj);
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public E pop() {
        return instance.remove();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (instance == null || instance.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @return size
     */
    @Override
    public int size() {
        return instance.size();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("StackD " +size() + ": ");

        return  builder.toString();
    }
}
