/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This is main class to test methods
 * @author Osman Akkus
 */
public class SingleLinkedListMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SingleLinkedList<Integer> example = new SingleLinkedList<>();

        for (int i = 0; i < 100; i++) {
            example.add(i);
        }

        System.out.println("List After added 100 elements");
        System.out.println(example.toString());

        System.out.println("List after removed 50 elements");
        for (int i = 100; i > 50; i--) {
            example.remove(example.getNode(i-1));
        }
        System.out.println(example.toString());

        System.out.println("Deleted Nodes");
        System.out.println(example.deletedToString());


        System.out.println("List After added 100 elements again.");
        for (int i = 1; i < 100; i++) {
            example.add(i);
        }
        System.out.println(example.toString());

        System.out.println("Deleted Nodes");
        System.out.println(example.deletedToString());

    }

}
