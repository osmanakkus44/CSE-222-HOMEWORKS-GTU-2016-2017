

/**
 * Created by Osman Akkus on 21.03.2017.
 */
public interface StackInterface<E>{

    /**
     * Push function to add new item
     * to the end of the list
     * @param obj
     * @return
     */
    E push(E obj);

    /**
     * Pop function to remove the and return
     * the last added element
     * @return
     */
    E pop();

    /**
     * isEmpty function to check the stack
     * is empty or not
     * @return
     */
    boolean isEmpty();

    /**
     * Size function to return the size of the
     * stack
     * @return
     */
    int size();

}
