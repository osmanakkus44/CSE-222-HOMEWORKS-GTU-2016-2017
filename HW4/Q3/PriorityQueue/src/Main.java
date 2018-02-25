import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by Osman Akkus on 24.03.2017.
 */
public class Main {
    public static void main(String args[]){


        try {
            BufferedReader fileReader = null;

            FileWriter file = new FileWriter("testResult_3.csv");

            String line = "";

            fileReader = new BufferedReader(new FileReader("test.csv"));

            while ((line = fileReader.readLine()) != null) {
                PriorityQueue<Object> instance = new PriorityQueue<>();
                PriorityQueue2<Object> instance2 = new PriorityQueue2<>();
                String [] tokens = line.split(",");

                for (String i : tokens) {
                    instance.offer(i);
                    instance2.offer(i);
                }
                /*Deleting the highest priority element from the Queues*/
                instance.deleteMin();
                instance2.deleteMin();

                /**
                 * Append them to the file
                 */
                file.append(instance.toString()).append("\n");
                file.append(instance2.toString()).append("\n");
                file.append("\n");

            }
            file.flush();
            file.close();

        }catch (Exception ex){
            System.out.println("Exception caught at: " + ex);
        }
    }
}
