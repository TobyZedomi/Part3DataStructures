package QueueApp;

import business.Task;
import utils.Queue;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        Scanner keyboard = new Scanner(System.in);


        String[] menu = new String[6];

        menu[0] = "1. Add a new Task";
        menu[1] = "2. View the Task";
        menu[2] = "3. Remove Task";
        menu[3] = "4. Amount Of Task";
        menu[4] = "5. Space left in Queue";
        menu[5] = "6. Exit";

        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
        System.out.println("");

        int number;

        System.out.println("Enter number in menu: ");
        number = keyboard.nextInt();


        if (number < 0 || number > menu.length) {

            System.out.println("Number not in menu");
        }
        System.out.println("");

        int size;

        System.out.println("Enter size you want Queue to be: ");
        size = keyboard.nextInt();

        Queue t1 = new Queue(size);

        t1.add(String.valueOf(new Task("Toby", "Lecture", LocalDate.of(2025, 12, 11))));
        t1.add(String.valueOf(new Task("Jack", "Footballer", LocalDate.of(2035, 11, 17))));
        t1.add(String.valueOf(new Task("Sam", "Basketball", LocalDate.of(2055, 10, 24))));
        t1.add(String.valueOf(new Task("John", "Red", LocalDate.of(2050, 8, 3))));


        switch (number) {


            case 1:


                String owner;
                System.out.println("Enter owner name: ");
                owner = keyboard.next();

                String description;
                System.out.println("Enter description: ");
                description = keyboard.next();

                Random rand = new Random();
                int answer = rand.nextInt(10) + 1;


                if (answer % 2 == 0) {

                    t1.add(String.valueOf(new Task(owner, description, LocalDate.of(2060, 9, 13))));

                    while (!t1.isEmpty()) {

                        System.out.println(t1.poll());
                    }
                } else {
                    t1.offer(String.valueOf(new Task(owner, description, LocalDate.of(2060, 9, 13))));

                    while (!t1.isEmpty()) {

                        System.out.println(t1.poll());
                    }
                }

                break;

            case 2:

                Random rand1 = new Random();
                int answer1 = rand1.nextInt(10) + 1;


                if (answer1 % 2 == 0) {

                    while (!t1.isEmpty()) {

                        System.out.println(t1.remove());
                    }
                } else {
                    while (!t1.isEmpty()) {

                        System.out.println(t1.poll());
                    }
                }
                break;

            case 3:

                Random rand2 = new Random();
                int answer2 = rand2.nextInt(10) + 1;

                if (answer2 % 2 == 0) {

                    System.out.println("Task that was removed: " + t1.remove());
                    System.out.println("Congratulations on removing task");
                    System.out.println("");

                    while (!t1.isEmpty()) {

                        System.out.println(t1.remove());

                    }
                } else {

                    System.out.println("Task that was removed: " + t1.poll());
                    System.out.println("Congratulations on removing task");
                    System.out.println("");

                    while (!t1.isEmpty()) {

                        System.out.println(t1.remove());

                    }

                }
                System.out.println("");

                break;


            case 4:
                System.out.println("Number of Task: " + t1.size());


                break;

            case 5:

                int numberLeft = size - t1.size();
                System.out.println("Number of task left: " + numberLeft);

                break;

            case 6:
                writeToFile(t1);
                System.out.println("Enter approach you think was used risky or safe?");
                keyboard.nextLine();
                String approach = keyboard.nextLine();
                if (approach.equalsIgnoreCase("safe")) {
                    System.out.println("Congratulations, you have guessed correctly!!");
                } else {
                    System.out.println("Unlucky, you guessed wrong better luck next time!!");
                }
                break;
            default:
                System.out.println("Invalid option. Please choose a number from 1 to 6.");
        }

/*
References

BeginnersBook. (n.d.). Java Program to print Even numbers from 1 to n or 1 to 100. Retrieved from BeginnersBook: https://beginnersbook.com/2019/04/java-program-to-print-even-numbers-from-1-to-n-or-1-to-100/


StackOverflow. (n.d.). Generating a Random Number between 1 and 10 Java [duplicate]. Retrieved from StackOverflow: https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java

 */

    }

    public static void writeToFile(Queue t1) {
        try {
            FileOutputStream fileout = new FileOutputStream("remaining_tasks.txt");
            while (!t1.isEmpty()) {
                fileout.write(t1.poll().toString().getBytes());
                fileout.write(System.lineSeparator().getBytes()); // Add a newline after each task
                //Reference
                //https://www.geeksforgeeks.org/system-lineseparator-method-in-java-with-examples/
            }
            fileout.close();
            System.out.println("Stored in file successfully");
        } catch (IOException e) {
            System.out.println("Failed to store in file: " + e.getMessage());
        }

    }

}

