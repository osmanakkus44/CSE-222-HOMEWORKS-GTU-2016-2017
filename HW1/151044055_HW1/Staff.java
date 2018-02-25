/**
 *
 * @author Osman Akkus
 */
public class Staff extends LibraryUser{
    
    private static int ALL_STAFF = 1;

    /**
     * @return the ALL_STAFF
     */
    public static int getALL_STAFF() {
        return ALL_STAFF;
    }

    /**
     * @param aALL_STAFF the ALL_STAFF to set
     */
    public static void setALL_STAFF(int aALL_STAFF) {
        ALL_STAFF = aALL_STAFF;
    }
    private Integer staffID = null;
    
    public Staff(String name, String surName, String userName, String password) {
        super(name, surName, userName, password);
        this.staffID = ALL_STAFF;
        ++ALL_STAFF;
    }
    public Staff(){
    }
    
    /**
     *Add a new book into the bookDatabase
     *@param addableBook
     *@param u
     */
    public void addBook(Book addableBook,LibraryUser u){
        u.getBookDatabase().add(addableBook);
    }
    
    /**
     *
     *@param removeableBook
     *@param u
     */
    public boolean removeBook(Book removableBook,LibraryUser u){
        u.getBookDatabase().remove(removableBook);
        return true;
    }
    /**
     *Add new user into the userDatabase
     *@param newUser
     *@param u
     */
    public boolean registerNewUser(GeneralUser newUser,LibraryUser u){
        u.getUserDatabase().add(newUser);
        return true;
    }
    
    /**
     *Remove the user from the userDatabase
     *@param addableBook
     *@param u
     */
    public boolean removeUser(GeneralUser removableUser,LibraryUser u){
        u.getUserDatabase().remove(removableUser);
        return true;
    }
    
    @Override
    public String toString(){
        return getStaffID() + "," + getName() + "," + getSurname() + "," + getUsername() + ","
               + getPassword() + "\n";
    }

    /**
     * @return the staffID
     */
    public Integer getStaffID() {
        return staffID;
    }

    /**
     * @param staffID the staffID to set
     */
    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    @Override
    public void printInfo() {
        System.out.println("ID: " + this.staffID);
        System.out.println("Name: " + this.getName());
        System.out.println("Surname: "+this.getSurname());
        System.out.println();
    }
    
}
