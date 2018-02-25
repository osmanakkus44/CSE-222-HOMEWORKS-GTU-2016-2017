import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Created by Osman Akkus on 07.05.2017.
 */
public class Main {

    /**
     * main method
     * @param args
     */
    public static void main(String[] args){
        try {
            if (TestFunc()){
                System.out.println("The Test function is executed successfully!");
            }
        } catch (Exception e) {
            System.out.println("Exception caught at: " + e);
        }
    }

    /**
     * This method tests the AVLTree with Integer values it
     * reads some integers from text file by readFile method
     * and insert them one by one. Then delete some items from the
     * list.It prints the AVLTree after the every process.
     * @return boolean true value if it executed normally
     * @throws IOException caught at main
     */
    public static boolean TestFunc() throws IOException {
        ArrayList<String> myString = readFile("t1.txt");

        AVLTree<Integer> myAVLTree = new AVLTree<>();

        for (int i = 0; i < myString.size(); i++) {
            String[] tokens = myString.get(i).split(",");

            for (int j = 0; j < tokens.length; j++) {
                myAVLTree.add(Integer.valueOf(tokens[j]));
            }
            System.out.println("AVL Tree after insertions");
            System.out.println(myAVLTree);
            System.out.println("Deleting the item  " + myAVLTree.delete(14));
            System.out.println(myAVLTree);
            System.out.println("Deleting the item  " + myAVLTree.delete(21));
            System.out.println(myAVLTree);
            System.out.println("Deleting the item  " + myAVLTree.delete(11));
            System.out.println(myAVLTree);
            System.out.println("Deleting the item  " + myAVLTree.delete(9));
            System.out.println(myAVLTree);
        }

        return true;
    }

    /**
     * This function reads the file and add into the ArrayList
     * to keep datas
     * @param fileName file name of the data
     * @return
     * @throws IOException
     */
    public static ArrayList readFile(String fileName) throws IOException {

        ArrayList<String> myString = new ArrayList<>();
        BufferedReader fileReader;
        String line;

        fileReader = new BufferedReader(new FileReader(fileName));

        while((line = fileReader.readLine()) != null){
            myString.add(line);
        }

        return myString;
    }

}
