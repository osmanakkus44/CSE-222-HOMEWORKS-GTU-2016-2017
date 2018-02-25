import java.util.*;
import java.io.*;

/** Class to represent and build a Huffman tree.
 *   @author Koffman and Wolfgang
 * */

public class HuffmanTree implements Serializable {

    // Nested Classes
    /** A datum in the Huffman tree. */
    public static class HuffData
            implements Serializable {
        // Data Fields
        /** The weight or probability assigned to this HuffData. */
        private double weight;

        /** The alphabet symbol if this is a leaf. */
        private String symbol;

        public HuffData(double weight, String symbol) {
            this.weight = weight;
            this.symbol = symbol;
        }
    }

    // Data Fields
    /** A reference to the completed Huffman tree. */
    private BinaryTree <HuffData> huffTree;
    private Map<String,String> data = new HashMap<>();


    /** A Comparator for Huffman trees; nested class. */
    private static class CompareHuffmanTrees
            implements Comparator < BinaryTree < HuffData >> {
        /** Compare two objects.
         @param treeLeft The left-hand object
         @param treeRight The right-hand object
         @return -1 if left less than right,
         0 if left equals right,
         and +1 if left greater than right
         */
        public int compare(BinaryTree <HuffData> treeLeft,
                           BinaryTree <HuffData> treeRight) {
            double wLeft = treeLeft.getData().weight;
            double wRight = treeRight.getData().weight;
            return Double.compare(wLeft, wRight);
        }
    }

    /** Builds the Huffman tree using the given alphabet and weights.
     post:  huffTree contains a reference to the Huffman tree.
     @param symbols An array of HuffData objects
     */
    public void buildTree(HuffData[] symbols) {
        Queue < BinaryTree < HuffData >> theQueue
                = new PriorityQueue <> (symbols.length, new CompareHuffmanTrees());
        // Load the queue with the leaves.
        for (HuffData nextSymbol : symbols) {
            if(nextSymbol != null){
                BinaryTree <HuffData> aBinaryTree =
                        new BinaryTree <> (nextSymbol, null, null);
                theQueue.offer(aBinaryTree);
            }
            else
                break;
        }

        // Build the tree.
        while (theQueue.size() > 1) {
            BinaryTree < HuffData > left = theQueue.poll();
            BinaryTree < HuffData > right = theQueue.poll();
            double wl = left.getData().weight;
            double wr = right.getData().weight;
            HuffData sum = new HuffData(wl + wr, null);
            BinaryTree < HuffData > newTree =
                    new BinaryTree < HuffData > (sum, left, right);
            theQueue.offer(newTree);
        }

        // The queue should now contain only one item.
        huffTree = theQueue.poll();
    }

    /**
     *This function makes the code
     * @param builder String Building to print
     * @param code
     * @param tree
     */
    private void printCode(StringBuilder builder, String code, BinaryTree <HuffData> tree) {

        HuffData theData = tree.getData();
        if (theData.symbol != null) {
            if (theData.symbol.equals("_")) {
                data.put(" ",code);
                builder.append(" space:" + code);
            }
            else {
                data.put(theData.symbol,code);
                builder.append(" " + theData.symbol + ":" + code);
            }
        }
        else{
            printCode(builder, code + "0", tree.getLeftSubtree());
            printCode(builder, code + "1", tree.getRightSubtree());
        }
    }

    /***
     *This function provide us to encode the given message
     * in case sensitive
     * @param message
     * @return
     */
    public String encode(String message){
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String code = "";
        String ch;
        printCode(temp,code,huffTree);
        code = message.toLowerCase();
        for (int i = 0; i < code.length(); i++){
            ch = String.valueOf(code.charAt(i));
            for (String key: data.keySet()) {
                if (key.equals(ch)){
                    builder.append(data.get(key));
                    break;
                }
            }
        }
        return builder.toString();
    }

    /** Method to decode a message that is input as a string of
     digit characters '0' and '1'.
     @param codedMessage The input message as a String of
     zeros and ones.
     @return The decoded message as a String
     */
    public String decode(String codedMessage) {
        StringBuilder result = new StringBuilder();
        BinaryTree < HuffData > currentTree = huffTree;
        for (int i = 0; i < codedMessage.length(); i++) {
            if (codedMessage.charAt(i) == '1') {
                currentTree = currentTree.getRightSubtree();
            }
            else {
                currentTree = currentTree.getLeftSubtree();
            }
            if (currentTree.isLeaf()) {
                HuffData theData = currentTree.getData();
                if (theData.symbol.equals("_"))
                    result.append(" ");
                else
                    result.append(theData.symbol);
                currentTree = huffTree;
            }
        }
        return result.toString();
    }

    /**
     * To string method
     * @return
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        String code = "";
        printCode(builder,code,huffTree);

        return builder.toString();
    }
}
