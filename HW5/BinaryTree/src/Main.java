import java.io.IOException;

/**
 * Created by Osman Akkus on 02.04.2017.
 */
public class Main {
    public  static  void main(String[] args){
        try {
            System.out.println("TESTING THE QUESTION 1.1:   "+  "\n");
            testIteratorTraverseTree("test.txt");
            System.out.println("\nTESTING THE QUESTION 1.2:   "+  "\n");
            testBinarySearchTreeIterator("test.txt");

        } catch (Exception e) {
            System.out.println("Exception caught at: " + e);
        }

    }

    /**
     * Test the first part of the first question
     * @param fileName
     * @throws IOException
     */
    public static void testIteratorTraverseTree(String fileName) throws IOException {
        IteratorTraverseTree<Integer> myInstance = new IteratorTraverseTree<>();
        myInstance.readFile(fileName);

        //The toString method of the IteratorTraverseTree written as preOrderTraverse string
        System.out.println(myInstance);
    }

    /**
     * Test the second part of the first question
     * @param fileName
     * @throws IOException
     */
    public static void testBinarySearchTreeIterator(String fileName) throws IOException{
        BinarySearchTree<Integer> myInstance = new BinarySearchTree<>();
        myInstance.readFile(fileName);

        //The toString method of the IteratorTraverseTree written as levelOrder string
        System.out.println(myInstance);
    }
}
