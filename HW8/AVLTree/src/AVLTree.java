/**
 * Self-balancing binary search tree using the algorithm defined
 * by Adelson-Velskii and Landis.
 * @author Koffman and Wolfgang
 */

public class AVLTree < E
        extends Comparable < E >> extends BinarySearchTreeWithRotate < E > {

    // Insert nested class AVLNode<E> here.

    // Data Fields
    /** Flag to indicate that height of tree has increased. */
    private boolean increase;

    /** Flag to indicate that height of tree has decreased */
    private boolean decrease;

    /** Class to represent an AVL Node. It extends the
     BinaryTree.Node by adding the balance field. */
    private static class AVLNode < E > extends Node < E> {
        /** Constant to indicate left-heavy */
        public static final int LEFT_HEAVY = -1;

        /** Constant to indicate balanced */
        public static final int BALANCED = 0;

        /** Constant to indicate right-heavy */
        public static final int RIGHT_HEAVY = 1;

        /** balance is right subtree height – left subtree height */
        private int balance;

        // Methods
        /** Construct a node with the given item as the data field.
         @param item The data field
         */
        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        /** Return a string representation of this object.
         The balance value is appended to the contents.
         @return String representation of this object
         */
        public String toString() {
            return balance + ": " + super.toString();
        }
    }

    /** add starter method.
     pre: the item to insert implements the Comparable interface.
     @param item The item being inserted.
     @return true if the object is inserted; false
     if the object already exists in the tree
     @throws ClassCastException if item is not Comparable
     */
    public boolean add(E item) {
        increase = false;
        root = add( (AVLNode <E>) root, item);
        return addReturn;
    }

    /** Recursive add method. Inserts the given object into the tree.
     post: addReturn is set true if the item is inserted,
     false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root of the subtree with the item
     inserted
     */
    private AVLNode < E > add(AVLNode < E > localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode <E> (item);
        }

        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        }

        else if (item.compareTo(localRoot.data) < 0) {
            // item < data
            localRoot.left = add((AVLNode <E> ) localRoot.left, item);

            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        }
        else {
            // item > data
            localRoot.right = add( (AVLNode <E> ) localRoot.right, item);
            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    increase = false;
                    return rebalanceRight(localRoot);
                }
            }
            return localRoot;
        }

    }
    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E delete(E target) {
        decrease = false;
        root = delete((AVLNode<E>) root, target);
        return deleteReturn;
    }

    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private AVLNode <E> delete(AVLNode <E> localRoot, E item) {
        if (localRoot == null) {
            decrease = false;
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);

        if (compResult == 0){
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                decrease = true;
                return (AVLNode<E>) localRoot.right;
            }
            else if (localRoot.right == null) {
                // If there is no right child, return left child.
                decrease = true;
                return (AVLNode<E>) localRoot.left;
            }
            else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                }
                else {
                    //Use the method of the super class(BinarySearchTree)
                    localRoot.data = findLargestChild(localRoot.left);
                }
                return  localRoot;
            }
        }
        else if (compResult < 0) {
            localRoot.left = delete((AVLNode<E>) localRoot.left, item);
            //Decrease from left means increment the parent balance if true
            if (decrease) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    return rebalanceRight(localRoot);
                }
            }
            return localRoot;
        }
        else{
            // item is larger than localRoot.data
            localRoot.right = delete((AVLNode<E>) localRoot.right, item);
            //Decrease from right means decrement the parent balance if true
            if (decrease) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot;
        }
    }

    /**
     * It takes a node which is right-heavy AVL tree it rebalance
     * it with rotation (Right-right or Right-Left)
     * @param localRoot to balance
     * @return  balanced localRoot
     */
    private AVLNode < E > rebalanceRight(AVLNode < E > localRoot) {

        AVLNode < E > rightChild = (AVLNode < E > ) localRoot.right;

        if (rightChild.balance < AVLNode.BALANCED) {

            AVLNode < E > rightLeftChild = (AVLNode < E > ) rightChild.left;

            if (rightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            else if (rightLeftChild.balance < AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            }
            else {
                rightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            //It means the tree is  decreasing
            increase = false;
            decrease = true;

            //doing double rotation here (Right-Left)
            localRoot.right = rotateRight(rightChild);
            return (AVLNode < E > ) rotateLeft(localRoot);
        }
        if (rightChild.balance > AVLNode.BALANCED) {

            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
            increase = false;
            decrease = true;
        }
        else {

            rightChild.balance = AVLNode.LEFT_HEAVY;
            localRoot.balance = AVLNode.RIGHT_HEAVY;
        }

        //Right-Right situation
        return (AVLNode < E > ) rotateLeft(localRoot);
    }

    /***
     * Pre: Take a localRoot is the root of an AVL subtree that is
     * critically left-heavy.
     * post: Balance is restored.
     * @param localRoot need to balancing
     * @return new balanced localRoot
     */
    private AVLNode < E > rebalanceLeft(AVLNode < E > localRoot) {
        // Obtain reference to left child.
        AVLNode < E > leftChild = (AVLNode < E > ) localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child.
            AVLNode < E > leftRightChild = (AVLNode < E > ) leftChild.right;
            /** Adjust the balances to be their new values after
             the rotations are performed.
             */
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            }
            else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }

            increase = false;
            decrease = true;

            // perform the double rotation(Left-right)
            localRoot.left = rotateLeft(leftChild);
            return (AVLNode < E > ) rotateRight(localRoot);
        }
        if (leftChild.balance < AVLNode.BALANCED) {

            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
            increase = false;
            decrease = true;
        }
        else {

            leftChild.balance = AVLNode.RIGHT_HEAVY;
            localRoot.balance = AVLNode.LEFT_HEAVY;
        }

        //perform rotation(Left-left)
        return (AVLNode < E > ) rotateRight(localRoot);
    }

    /**
     *Decrementing the balance of the root
     * @param node to check the balance is zero balance or not
     */
    private void decrementBalance(AVLNode <E> node) {
        // Decrement the balance.
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            increase = false;
        }
    }

    /**
     * If the balance is greater than 0 it increases
     * If is not it decreases
     * @param node to check the balnce is zero balnced or not
     */
    private void incrementBalance(AVLNode<E> node){
        // Increment the balance.
        node.balance++;

        //if balance greater than zero increase = true, decrease = false
        if (node.balance > AVLNode.BALANCED){
            increase = true;
            decrease = false;
        }
        else{//if balance less than or equal zero decrease = true,increase = false
            increase = false;
            decrease = true;
        }
    }
}
