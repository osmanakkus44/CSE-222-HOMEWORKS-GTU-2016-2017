import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Osman Akkus
 */
public class GeneralUser extends LibraryUser{
    
    private static int ALL_USER = 1;

    /**
     * @return the ALL_USER
     */
    public static int getALL_USER() {
        return ALL_USER;
    }

    /**
     * @param aALL_USER the ALL_USER to set
     */
    public static void setALL_USER(int aALL_USER) {
        ALL_USER = aALL_USER;
    }
    private Integer userID = null;
    private List<Book> books = null;
    
    /**
     * 
     * @param name
     * @param surName
     * @param userName
     * @param password 
     */
    public GeneralUser(String name, String surName, String userName, String password) {
        //calling superclass constructor
        super(name, surName, userName, password);
        books = new ArrayList<>();
        this.userID = ALL_USER;
        ++ALL_USER;
    }

    /**
     *No paramater constructor to be able to create an object with no paramater
     */
    public GeneralUser() {
        books = new ArrayList<>();
    }
    
    /**
     *
     *@param index
     *@param u
     */
    public  void borrowBook(Integer index,LibraryUser u){
        books.add(u.getBookDatabase().get(index));
        u.getBookDatabase().remove(u.getBookDatabase().get(index));
    }
    /**
     *
     *@param index
     *@param u
     */
    public void returnBook(Integer index,LibraryUser u){
        u.getBookDatabase().add(books.get(index));
        books.remove(u.getBookDatabase().get(index));
    }
    
    /**
     * @return the userID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * @return the books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    @Override
    public String toString(){
        return getUserID() + "," + getName() + "," + getSurname() + "," + getUsername() + ","
               + getPassword() + "\n";
    }

    @Override
    public void printInfo() {
        System.out.println("ID: "+this.userID);
        System.out.println("Name: "+this.getName());
        System.out.println("Surname: " + this.getSurname());
        System.out.println();
    }
}
