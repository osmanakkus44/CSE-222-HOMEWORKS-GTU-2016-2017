import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * Created by otto on 22.03.2017.1
 */
public class Main <E>{

    public static void main(String args[]){


        try {
            BufferedReader fileReader = null;

            FileWriter file = new FileWriter("testResult_1.csv");

            String line = "";

            fileReader = new BufferedReader(new FileReader("test.csv"));

            while((line = fileReader.readLine()) != null){

                String [] tokens = line.split(",");

                StackA<Object> stackA = new StackA<>();
                StackB<Object> stackB = new StackB<>();
                StackC<Object> stackC = new StackC<>();
                StackD<Object> stackD = new StackD<>();

                for (String i : tokens) {
                    stackA.push(i);
                    stackB.push(i);
                    stackC.push(i);
                    stackD.push(i);
                }

                file.append(stackA.toString()).append(line).append("\n");
                file.append(stackB.toString()).append(line).append("\n");
                file.append(stackC.toString()).append(line).append("\n");
                file.append(stackD.toString()).append(line).append("\n\n");

            }

            file.flush();
            file.close();

        }
        catch (Exception ex){
            System.out.println("Exception caught at: " + ex);
        }
    }
}
