/**
 *Includes Book informations
 * @author Osman Akkus
 */
public class Book {

    /**
     * @return the ALL_BOOK
     */
    public static int getALL_BOOK() {
        return ALL_BOOK;
    }

    /**
     * @param aALL_BOOK the ALL_BOOK to set
     */
    public static void setALL_BOOK(int aALL_BOOK) {
        ALL_BOOK = aALL_BOOK;
    }

    private String bookName = null;
    private String authorName = null;
    private Integer bookID = null;

    private static int ALL_BOOK = 1;


    public Book(String bookName, String author){
        this.bookName = bookName;
        this.authorName = author;
        this.bookID = ALL_BOOK;
        ++ALL_BOOK;
    }


    @Override
    public String toString(){
        return getBookID() + "," + getBookName() + "," + getAuthorName() + "\n";
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the bookID
     */
    public Integer getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }
}
