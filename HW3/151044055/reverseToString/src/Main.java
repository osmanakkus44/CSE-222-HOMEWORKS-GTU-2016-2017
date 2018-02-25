/**
 *The main class to test the SingleLinkedList methods.(Especially reverseToString)
 * @author Osman Akkus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SingleLinkedList<String> abc= new SingleLinkedList<>();
        String testingWord = "Lorem ipsum dolor sit amet";

        abc.add(testingWord);

        System.out.println("-Testing the recursive reverse To String Method-");
        System.out.println("The testing word is: " + abc.get(0));
        System.out.println("-After the reversing process-");

        testingWord = abc.reverseToString(testingWord);
        abc.add(testingWord);

        System.out.println("The testing word is: " + abc.get(1));

        System.out.println("-Another testing-");

        String reverseToString = abc.reverseToString(abc.toString());

        abc.toString();
        System.out.println("Reversed To String method: " + reverseToString);

    }

}
