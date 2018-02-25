/**
 *
 * @author Osman Akkus
 */
public interface LibraryUserInterface {
    /**
     * 
     * @return name of the LibraryUser
     */
    String getName();
    
    /**
     * 
     * @return surname of the LibraryUser
     */
    String getSurname();
    
    /**
     * 
     * @return username of the LibraryUser
     */
    String getUsername();
    
    /**
     * 
     * @return password of the LibraryUser 
     */
    String getPassword();
    
    
    void printInfo();
        
}
