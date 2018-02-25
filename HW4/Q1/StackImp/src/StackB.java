import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by Osman Akkus on 21.03.2017.
 */
public class StackB<E> implements StackInterface<E>{

    ArrayList<E> instance = null;

    /**
     * No parameter class to initialize the data members
     */
    public StackB(){
        instance = new ArrayList<E>();
    }

    /**
     * Push function add to the data member Arraylist
     * @param obj
     * @return
     */
    @Override
    public E push(E obj) {
        instance.add(obj);
        return obj;
    }

    /**
     * Pop function remove the last value of the
     * stack and return it
     * @return E type obj or exception
     * @throws EmptyStackException
     */
    @Override
    public E pop() throws EmptyStackException{
        try {
            return instance.remove(size() - 1);
        }catch (ArrayIndexOutOfBoundsException exc){
            throw new EmptyStackException();
        }
    }

    /**
     * Check the emptyness of the stack
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return instance.isEmpty();
    }

    /**
     * Provides us to know the size of
     * stack
     * @return size of stack
     */
    @Override
    public int size() {
        return instance.size();
    }

    /**
     *toString method of StackB
     * @return
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("StackB " +size() + ": ");

        return  builder.toString();
    }
}
