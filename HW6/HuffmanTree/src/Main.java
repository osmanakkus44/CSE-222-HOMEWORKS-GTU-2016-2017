/**
 * Created by Osman Akkus on 19.04.2017.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *This main is testing for the FamilyTree Class
 */
public class Main {

    private  static HuffmanTree.HuffData[] data = new HuffmanTree.HuffData[30];

    /**
     * This main class test the huffman tree and encode and decode
     * @param args
     */
    public static void main(String[] args){
        try{
            HuffmanTree myHuffTree = new HuffmanTree();
            String message = "it works perfectly";
            String codeMessage;
            String result;
            ArrayList<String> newList = readFile("freq.txt");
            fill(newList);
            myHuffTree.buildTree(data);
            System.out.println("TESTING THE QUESTION 2 OF HW6: " + "\n");

            System.out.println("The message gonna be encrypted: \n" + message);
            codeMessage = myHuffTree.encode(message);
            System.out.println("\nEncrypted message is: \n" + codeMessage);
            result = myHuffTree.decode(codeMessage);
            System.out.println("\nAfter decode the message is: \n" + result);

        }catch (Exception e){
            System.out.println("Exception caught at: " + e);
        }
    }

    /**
     * This function reads the file and add into the ArrayList
     * to keep datas
     * @param fileName file name of the data
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList readFile(String fileName) throws FileNotFoundException,IOException {

        ArrayList<String> myString = new ArrayList<>();

        BufferedReader fileReader = null;

        String line = "";

        fileReader = new BufferedReader(new FileReader(fileName));

        while((line = fileReader.readLine()) != null){
            myString.add(line);
        }

        return myString;
    }

    /**
     * The static method to fill HuffData
     * @param list
     */
    public static void fill(ArrayList<String> list){
        String [] tokens;
        int i = 0;
        while(i < list.size()){
            tokens = list.get(i).split(" ");
            data[i] = new HuffmanTree.HuffData(Double.valueOf(tokens[1]),tokens[0]);
            i++;
        }
        return;
    }
}
