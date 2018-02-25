import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.StringJoiner;

/**
 * Created by Osman Akkus on 21.03.2017.
 */
public class StackA<E> extends ArrayList<E> implements StackInterface<E>{

    /**
     *Add a new element using Arraylist add function
     * @param obj
     * @return
     */
    @Override
    public E push(E obj) {
        add(obj);
        return obj;
    }

    /**
     *Remove the last element of the stack and return the value
     * @return
     * @throws EmptyStackException
     */
    @Override
    public E pop()throws EmptyStackException{
        try {
            return  remove(size() -1);

        }catch (ArrayIndexOutOfBoundsException exc){
            throw new EmptyStackException();
        }
    }

    /**
     *Check the stack is empty or not
     * @return
     */
    @Override
    public boolean isEmpty(){
        return super.isEmpty();
    }

    /**
     *Provides us the size of the stack
     * @return
     */
    @Override
    public int size(){
        return super.size();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
       StringBuilder builder = new StringBuilder();
       builder.append("StackA " + size() + ": ");

       return  builder.toString();
    }
}
