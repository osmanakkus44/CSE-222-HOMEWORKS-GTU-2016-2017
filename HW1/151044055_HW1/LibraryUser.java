import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Osman Akkus
 */
public abstract class LibraryUser implements LibraryUserInterface {
    
    private String name = null;
    private String surName = null;
    private String userName = null;
    private String password = null;
    
    private List<Book> bookDatabase = null;
    private List<GeneralUser> userDatabase = null;
    private List<Staff> staffDatabase = null;
    
    
    /**
     *
     * @param name
     * @param surName
     * @param userName
     * @param password
     */
    protected LibraryUser(String name, String surName,String userName,String password){
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.password = password;
        bookDatabase = new ArrayList<>();
        userDatabase = new ArrayList<>();
        staffDatabase = new ArrayList<>();
    }
    
    /**
     *
     */
    protected LibraryUser(){
        bookDatabase = new ArrayList<>();
        userDatabase = new ArrayList<>();
        staffDatabase = new ArrayList<>();
    }
    
    /**
     * 
     * @return name of the library user 
     */
    @Override
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @return surname
     */
    @Override
    public String getSurname(){
        return surName;
    }
    
    /**
     * 
     * @return userName 
     */
    @Override
    public String getUsername(){
        return userName;
    }
    
    
    
    @Override
    public String getPassword(){
        return password;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the bookDatabase
     */
    public List<Book> getBookDatabase() {
        return bookDatabase;
    }

    /**
     * @param bookDatabase the bookDatabase to set
     */
    public void setBookDatabase(List<Book> bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    /**
     * @return the userDatabase
     */
    public List<GeneralUser> getUserDatabase() {
        return userDatabase;
    }

    /**
     * @param userDatabase the userDatabase to set
     */
    public void setUserDatabase(List<GeneralUser> userDatabase) {
        this.userDatabase = userDatabase;
    }

    /**
     * @return the staffDatabase
     */
    public List<Staff> getStaffDatabase() {
        return staffDatabase;
    }

    /**
     * @param staffDatabase the staffDatabase to set
     */
    public void setStaffDatabase(List<Staff> staffDatabase) {
        this.staffDatabase = staffDatabase;
    }
}
