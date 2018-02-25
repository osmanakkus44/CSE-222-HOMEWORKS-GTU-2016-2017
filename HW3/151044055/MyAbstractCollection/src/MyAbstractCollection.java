/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 *This class has a appendAnything method to append the two object
 *
 * @author Osman Akkus
 */
public class MyAbstractCollection <E> extends AbstractCollection<E>{

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean appendAnything(E other){

        super.add(other);

        return true;
    }

}
