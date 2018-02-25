import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Osman Akkus
 */
public class LibraryReadingFile {
    
    private static final String SEPERATOR = ",";
    
    /**
     * 
     * @param fileName
     * @param other
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @SuppressWarnings("UnusedAssignment")
    public static void readFile(String fileName, List<GeneralUser> other) 
            throws FileNotFoundException, IOException{
        
        BufferedReader fileReader = null;
        
        String line = "";
        
        fileReader = new BufferedReader(new FileReader(fileName));
        
        while((line = fileReader.readLine()) != null){
            String [] array = line.split(SEPERATOR);
            
            other.add(new GeneralUser(array[1],array[2],array[3],array[4]));
        }
    }
    
    /**
     *
     * @param fileName
     * @param other
     * @param ignoreMe
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("UnusedAssignment")
    public static void readFile(String fileName, List<Staff> other,
            int ignoreMe) throws FileNotFoundException, IOException{
        
        BufferedReader fileReader = null;
        
        String line = "";
        
        fileReader = new BufferedReader(new FileReader(fileName));
        
        while((line = fileReader.readLine()) != null){
            String [] array = line.split(SEPERATOR);
            
            other.add(new Staff(array[1],array[2],array[3],array[4]));
        }
    }

    /**
     *
     * @param fileName
     * @param other
     * @param ignoreMe
     * @param igMe
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("UnusedAssignment")
    public static void readFile(String fileName, List<Book> other,
            int ignoreMe,int igMe) throws FileNotFoundException, IOException{
        
        BufferedReader fileReader = null;
        
        String line = "";
        
        fileReader = new BufferedReader(new FileReader(fileName));
        
        while((line = fileReader.readLine()) != null){
            String [] array = line.split(SEPERATOR);
            
            other.add(new Book(array[1],array[2]));
        }
    }
}
