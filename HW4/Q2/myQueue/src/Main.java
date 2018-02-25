import java.io.*;

/**
 * Created by otto on 23.03.2017.
 */
public class Main {
    public  static  void main(String args[]){
        try{

            BufferedReader fileReader = null;

            FileWriter file = new FileWriter("testResult_2.csv");

            String line = "";

            fileReader = new BufferedReader(new FileReader("test.csv"));

            while((line = fileReader.readLine()) != null){

                myQueue<Object> myQueue = new myQueue<>();

                String [] tokens = line.split(",");

                for (String i : tokens){
                    myQueue.offer(i);
                }

                /**
                 * first reverse method testing here and adds the result
                 * in the file
                 */
                file.append("Reverse Iterative ");
                file.append(myQueue.reverseIterative()).append("\n");


                /**
                 * Recursive reverse method testing here and append the result intfile
                 */
                file.append("Reverse Recursively ");
                file.append(myQueue.reverseRecursively(myQueue)).append("\n");

                file.append("\n");

            }

            file.flush();
            file.close();

        }catch (Exception ex){
            System.out.println("Exception caught at: " + ex);
        }
    }

}
