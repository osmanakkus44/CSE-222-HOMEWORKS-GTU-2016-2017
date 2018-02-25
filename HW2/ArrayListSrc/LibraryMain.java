import java.io.IOException;
import java.util.Scanner;

/**
 *LibraryMain.java : 
 *This main class has a static void main method that calls some static methods 
 *from Test class and it has a try catch block to catch Exceptions
 * @author Osman Akkus
 */
public class LibraryMain {

    private static boolean exitStatus = false;

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings({"empty-statement", "UnusedAssignment"})
    public static void main(String[] args) {
        try {
            do {
            	//admin object to manage the database
                LibraryUser admin = new Staff();

                Test.readDatabase(admin);

                String presantation = "Welcome to the Library Managament System";
                System.out.println(presantation);

                System.out.println("[1]Login");
                System.out.println("[2]Register");
                System.out.println("[-1]Exit");

                Scanner keyboard = new Scanner(System.in);
                Integer choice = keyboard.nextInt();//ask user to choose operation

                if (choice.equals(1)) {
                    System.out.println("Login System as: ");
                    System.out.println
                    ("[1] User" + "\n" + "[2] Staff" + "\n" + "[-1]Return Menu");
                    Integer choiceLogin = keyboard.nextInt();

                    //check the given option that for user or for staff
                    Test.checkLogin(choiceLogin, admin);
                }
                if (choice.equals(2)) {
                    System.out.println("Register System as: ");
                    System.out.println("[1] Staff" + "\n" + "[-1]Return Menu");
                    Integer choiceRegister = keyboard.nextInt();
                    Test.checkAndRegister(choiceRegister, admin);
                }
                if (choice.equals(-1)) {
                    exitStatus = true;
                }
            } while (exitStatus == false);
        } catch (Exception e) {
            System.err.println("Error occured at: " + e);
            e.getMessage();
            System.exit(1);
        }

    }

}