/**
 * Created by Osman Akkus on 05.04.2017.
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
    public static void main(String[] args){
        try{
            ArrayList<String> newList = readFile("test.txt");
            FamilyTree<String> myInstance = new FamilyTree<>(newList.get(0));
            myInstance.add(newList);

            System.out.println("TESTING THE QUESTION 3 For Level Order Traverse: " + "\n");
            System.out.println(myInstance);

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
}
