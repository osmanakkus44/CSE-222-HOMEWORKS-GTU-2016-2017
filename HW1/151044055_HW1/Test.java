import java.io.IOException;
import java.util.Scanner;

/**
 *Test.java:
 *This class includes only static methods to call by main class and we can say
 *this class manages all operations of library database 
 *
 * @author Osman Akkus
 */
public class Test 
{
     /**
     *
     *
     * @param choice
     * @param admin
     * @throws IOException
     */
    public static void checkLogin(Integer choice, LibraryUser admin) throws IOException {
        if (choice.equals(1)) {
            checkUserFunc(admin);
        }
        if (choice.equals(2)) {
            checkStaffFunc(admin);
        }
    }

    /**
     * That static function takes the @param choice  and @param addStaff 
     * and execute the all registration processes and add a new staff into 
     * staffDatabase
     * @param choice
     * @param addStaff
     * @throws IOException
     */
    public static void checkAndRegister(Integer choice, LibraryUser addStaff)
            throws IOException 
    {
        
        if(choice.equals(1)){
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter the information below");
            System.out.print("Name: ");
            String name = keyboard.nextLine();
            System.out.print("Surname: ");
            String surname = keyboard.nextLine();
            System.out.print("Username: ");
            String username = keyboard.nextLine();
            System.out.print("Password: ");
            String password = keyboard.nextLine();

            boolean flag = true;
            for (int b = 0;b < addStaff.getStaffDatabase().size();b++) {
                if(addStaff.getStaffDatabase().get(b).getUsername() == username){
                    System.out.println("This user has already exist");
                    flag = false;
                    break;
                }   
            }

            //Adding new user into the staffDatabase
            if(flag == true){
                addStaff.getStaffDatabase().add(new Staff(name, surname, username, password));
            }

            //update database file staff.csv
            writeDatabase(addStaff);
        }
    }

    /**
     *Read whole database from files by static methods of LibraryReadingFile
     * @param admin
     * @throws IOException
     */
    public static void readDatabase(LibraryUser admin) throws IOException {
        String userFileName = "users.csv";
        String staffFileName = "staffs.csv";
        String bookFileName = "books.csv";

        LibraryReadingFile.readFile(userFileName, admin.getUserDatabase());
        LibraryReadingFile.readFile(staffFileName, admin.getStaffDatabase(), 0);
        LibraryReadingFile.readFile(bookFileName, admin.getBookDatabase(), 0, 0);
    }

    /**
     *
     * @param checkUser
     * @throws IOException
     */
    public static void checkUserFunc(LibraryUser checkUser) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\n" + "Please make sure that you have registered"
                + " by Staff.Otherwise You can't enter the System");

        System.out.print("UserName: ");
        String username = keyboard.nextLine();
        System.out.print("Password: ");
        String password = keyboard.nextLine();

        boolean flagOfUser = false;
        int i = 0;
        Integer userIndex = null;

        //Checks the given user exist or not
        while (flagOfUser == false && i < checkUser.getUserDatabase().size()) {
            if (username.equals(checkUser.getUserDatabase().get(i).getUsername())) {
                if (password.equals(checkUser.getUserDatabase().get(i).getPassword())) {
                    flagOfUser = true;
                    userIndex = i;
                }
            }
            i++;
        }
        if (flagOfUser == false) {
            System.err.println("You aren't registered by Staff."
                    + "Please register and try again.Only Staff can "
                    + "register a new user");
        } else {
            boolean flag = false;

            do {
                System.out.println("\nOperations You Can Do");
                System.out.println("[1] Borrow A Book");
                System.out.println("[2] Return A Book");
                System.out.println("[-1] Return Home");

                Integer uChoice = keyboard.nextInt();

                if (uChoice.equals(1)) {
                    System.out.println("\nChoose the book by its ID to borrow ");
                    if (checkUser.getBookDatabase().size() > 0) {
                        for (int j = 0; j < checkUser.getBookDatabase().size(); j++) {
                            System.out.println(checkUser.getBookDatabase()
                                    .get(j).toString());
                        }
                        Integer bChoice = keyboard.nextInt();
                        
                        checkUser.getUserDatabase().get(userIndex).borrowBook(bChoice - 1, checkUser);
                        System.out.println(checkUser.getUserDatabase().get(userIndex).getBooks());
                    } else {
                        System.out.println("No book to borrow");
                    }
                    writeDatabase(checkUser);
                }
                if (uChoice.equals(2)) {

                    System.out.println("\nChoose the book by its ID to return ");

                    for (int j = 0; j < checkUser.getUserDatabase().
                            get(userIndex).getBooks().size(); j++) {
                        System.out.println(checkUser.getUserDatabase().
                                get(userIndex).getBooks().get(j).toString());
                    }

                    Integer bChoice = keyboard.nextInt();

                    checkUser.getUserDatabase().get(userIndex).
                            returnBook(bChoice - 1, checkUser);

                    writeDatabase(checkUser);
                }
                if (uChoice.equals(-1)) {
                    flag = true;
                }

            } while (flag == false);
        }
    }

    /**
     *
     * @param checkUser
     * @throws IOException
     */
    public static void checkStaffFunc(LibraryUser checkUser) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("\nEnter Your" + "\n");
        System.out.print("UserName: ");
        String username = keyboard.nextLine();
        System.out.print("Password: ");
        String password = keyboard.nextLine();

        boolean flagOfUser = false;
        int i = 0;
        Integer staffIndex = null;

        while (flagOfUser == false && i < checkUser.getStaffDatabase().size()) {
            if (username.equals(checkUser.getStaffDatabase().get(i).getUsername())) {
                if (password.equals(checkUser.getStaffDatabase().get(i).getPassword())) {
                    flagOfUser = true;
                    staffIndex = i;
                }
            }
            i++;
        }

        if (flagOfUser == false) {
            System.err.println("You aren't registered as a Staff."
                    + "Please register and try again.");
        } else {
            boolean flag = false;

            do {
                System.out.println("\nOperations You Can Do");
                System.out.println("[1] Add A New Book");
                System.out.println("[2] Remove A Book");
                System.out.println("[3] Add A New User");
                System.out.println("[4] Remove A User");
                System.out.println("[5] List All User");
                System.out.println("[6] List All Staff");
                System.out.println("[-1] Return Home");

                Integer sChoice = keyboard.nextInt();

                if (sChoice.equals(1)) {
                    System.out.println("\nEnter the information below");
                    System.out.print("BookName: ");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.print("Author: ");
                    String author = keyboard.nextLine();

                    Book addBook = new Book(name, author);

                    checkUser.getStaffDatabase().get(staffIndex).addBook(addBook, checkUser);

                    writeDatabase(checkUser);
                } else if (sChoice.equals(2)) {

                    System.out.println("\nChoose the book by its ID to remove ");

                    if (checkUser.getBookDatabase().size() > 0) {
                        for (int j = 0; j < checkUser.getBookDatabase().size(); j++) {
                            System.out.println(checkUser.getBookDatabase().get(j).toString());
                        }
                        Integer bChoice = keyboard.nextInt();
                        checkUser.getStaffDatabase().get(staffIndex)
                                .removeBook(checkUser.getBookDatabase().get(bChoice - 1), checkUser);
                    } else {
                        System.out.println("No book to remove");
                    }
                    writeDatabase(checkUser);

                } else if (sChoice.equals(3)) {
                    System.out.println("\nEnter the information below");
                    System.out.print("Name: ");
                    keyboard.nextLine();
                    String gName = keyboard.nextLine();
                    System.out.print("Surname: ");
                    String gSurname = keyboard.nextLine();
                    System.out.print("Username: ");
                    String gUsername = keyboard.nextLine();
                    System.out.print("Password: ");
                    String gPassword = keyboard.nextLine();

                    boolean addUserFlag = true;
                    for (int a = 0;a < checkUser.getUserDatabase().size();a++) {
                    	if(checkUser.getUserDatabase().get(a).getUsername() == gUsername){
                            addUserFlag =false;
                    		break;
                        }      	
                    }
                    if (addUserFlag == true) {
                        checkUser.getUserDatabase().
                        add(new GeneralUser(gName, gSurname, gUsername, gPassword));
                    }        
                    
                    writeDatabase(checkUser);
                } else if (sChoice.equals(4)) {
                    System.out.println("\nChoose the user by its ID to remove");

                    if (checkUser.getUserDatabase().size() > 0) {
                        for (int j = 0; j < checkUser.getUserDatabase().size(); j++) {
                            System.out.println(checkUser.getUserDatabase().get(j).toString());
                        }
                        Integer uChoice = keyboard.nextInt();
                        checkUser.getStaffDatabase().get(staffIndex)
                                .removeUser(checkUser.getUserDatabase().get(uChoice - 1), checkUser);
                    } else {
                        System.out.println("No user to remove");
                    }
                    writeDatabase(checkUser);
                    
                } else if (sChoice.equals(5)) {
                	for (int k = 0; k < checkUser.getUserDatabase().size(); k++) {
                    	printAll(checkUser.getUserDatabase().get(k));  
                    }
                } else if (sChoice.equals(6)) {
                	for (int l = 0; l < checkUser.getStaffDatabase().size(); l++) {
                    	printAll(checkUser.getStaffDatabase().get(l));  
                    }
                } else if (sChoice.equals(-1)) {
                    flag = true;
                } else {
                    System.out.println("\nWrong option try again");
                }
            } while (flag == false);
        }
    }

    /**
     *
     * @param admin
     * @throws IOException
     */
    public static void writeDatabase(LibraryUser admin) throws IOException {

        String userFileName = "users.csv";
        String staffFileName = "staffs.csv";
        String bookFileName = "books.csv";
        
        Book.setALL_BOOK(1);
        GeneralUser.setALL_USER(1);
        Staff.setALL_STAFF(1);
        
        LibraryWritingFile.writeFile(userFileName, admin.getUserDatabase());
        LibraryWritingFile.writeFile(staffFileName, admin.getStaffDatabase(), 0);
        LibraryWritingFile.writeFile(bookFileName, admin.getBookDatabase(), 0, 0);
    }


    //Static POLYMORPHIC method  
    /**
     *
     *@param obj
     */
    public static void printAll(LibraryUserInterface obj){
    	obj.printInfo();
    }

}

