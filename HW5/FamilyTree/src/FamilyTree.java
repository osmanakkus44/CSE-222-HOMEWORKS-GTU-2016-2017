import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This is the FamilyTree class to generate a Family Tree
 * using Binary Tree
 * Created by Osman Akkus on 05.04.2017.
 */
public class FamilyTree<E> extends BinaryTree<E>{

    //Generated new root
    private Node<E> root;
    //Current node
    private Node<E> current = null;

    public FamilyTree(E item){
        root = new Node(item);
    }

    /**
     * Add method that takes ArrayList method every time
     * calls the other overloaded add method to create the
     * whole of the Binary Tree
     * @param list
     * @return
     */
    public boolean add(ArrayList<String> list){
        String [] tokens;
        int i = 1;
        while(i < list.size()){
            tokens = list.get(i).split(",");
            add(tokens[0],tokens[1],tokens[2]);
            i++;
        }
        return true;
    }

    /**
     * To string method to create the String of the this object
     * @return generated String
     */
    @Override
    public String toString(){
       BinaryTree<E> instance = new BinaryTree<E>(root);
       return instance.toString();
    }

    /**
     * Overloaded add method takes three parameters
     * @param name is to be added
     * @param parent name of the name to be added
     * @param nickname of the parent
     * @return true or false or may be throw  NoSuchElementException
     */
    public boolean add(String name, String parent, String nickname){

        familyTreeContains(root,(E)parent);

        String [] nicknameTokens = nickname.split("-");

        if (current == null)
            throw new NoSuchElementException();
        else {

            if (current.left != null){
                if (nicknameTokens[0].equals("ebu")){
                    if (current.left.data.equals(nicknameTokens[1])){
                        current.left.right = new Node(name);
                    }
                }
                else if (nicknameTokens[0].equals("ibn")){
                    if (current.data.equals(nicknameTokens[1])){
                        current.left.right = new Node(name);
                    }
                }
                else {
                    throw new NoSuchElementException();
                }
            }
            else{
                current.left = new Node(name);
            }
        }

        return true;
    }

    /**
     * This checks the parent is exist in the tree
     * if it exist it return the current node of the binary tree
     * @param node given node(root)
     * @param parent given name of the parent
     */
    public void familyTreeContains(Node<E> node,E parent){

        if (node != null){
            if (node.data.equals(parent)){
                current = node;
                return;
            }
        }
        else {
            return;
        }
        familyTreeContains(node.left,parent);
        familyTreeContains(node.right,parent);

        return;
    }

}
