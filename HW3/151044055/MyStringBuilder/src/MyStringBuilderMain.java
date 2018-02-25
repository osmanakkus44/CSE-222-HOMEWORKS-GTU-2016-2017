/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Main Class for Testing
 */
public class MyStringBuilderMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SingleLinkedList<Integer> numbers = new SingleLinkedList<>();

        MyStringBuilder builder = new MyStringBuilder();

        try {

            Scanner reader = new Scanner(new File("numbers.txt"));

            FileWriter file = null;

            while (reader.hasNextInt()) {
                numbers.add(reader.nextInt());
            }

            System.out.println(numbers.toString());
            System.out.println("Size: " + numbers.size());

            for (int i = 0; i < numbers.size(); i++) {
                builder.append(numbers.get(i));
            }

            System.out.println("--toStringUsesIndexAndGet() method--");
            System.out.println(builder.toStringUsesIndexAndGet());
            file = new FileWriter("result1.txt");
            file.append(builder.toStringUsesIndexAndGet());

            System.out.println("--toStringUsesIterator() method--");
            System.out.println(builder.toStringUsesIterator());
            file = new FileWriter("result2.txt");
            file.append(builder.toStringUsesIterator());

            System.out.println("--toStringUsesLinkedList() method--");
            System.out.println(builder.toStringUsesLinkedList());
            file = new FileWriter("result3.txt");
            file.append(builder.toStringUsesLinkedList());

            System.out.println("Builder completed succesully and written on file...");
        }
        catch (Exception e) {
            System.out.println("Error ocuured at: " + e);
        }
    }

}
