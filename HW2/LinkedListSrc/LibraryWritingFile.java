import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Osman Akkus
 */
public class LibraryWritingFile {

    private static final String SEPERATOR = ",";
    private static final String NL_SEPERATOR = "\n";

    /**
     *
     * @param fileName
     * @param users
     * @throws IOException
     */
    public static void writeFile(String fileName,
                                 List<GeneralUser> users) throws IOException{

        FileWriter file = new FileWriter(fileName);

        int i = 1;
        for(GeneralUser user : users){
            file.append("[" + String.valueOf(i) + "] ");
            file.append(user.toString());
            i++;
        }

        file.flush();
        file.close();

    }

    /**
     *
     * @param fileName
     * @param staffs
     * @param ignoreMe
     * @throws IOException
     */
    public static void writeFile(String fileName,
                                 List<Staff> staffs,int ignoreMe) throws IOException{
        FileWriter file = new FileWriter(fileName);

        int i = 1;
        for(Staff staff : staffs){
            file.append("[" + String.valueOf(i) + "] ");
            file.append(staff.toString());
            i++;
        }

        file.flush();
        file.close();

    }

    /**
     *Write the file again for Book database
     * @param fileName
     * @param books
     * @param ignoreMe
     * @param igMe
     * @throws IOException
     */
    public static void writeFile(String fileName,
                                 List<Book> books,int ignoreMe,int igMe) throws IOException{
        FileWriter file = new FileWriter(fileName);

        int i = 1;
        for(Book book : books){
            file.append("[" + String.valueOf(i) + "] ");
            file.append(book.toString());
            i++;
        }

        file.flush();
        file.close();

    }

}    