package QueueApp;

import business.Task;
import utils.Queue;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        Scanner keyboard = new Scanner(System.in);

        /*
        Queue t1 = new Queue(6);

        t1.add(String.valueOf(new Task("Toby", "Lecture", LocalDate.of(2025,12,11))));
        t1.add(String.valueOf(new Task("Jack", "Footballer", LocalDate.of(2035,11,17))));
        t1.add(String.valueOf(new Task("Sam", "Basketball", LocalDate.of(2055,10,24))));
        t1.add(String.valueOf(new Task("John", "Red", LocalDate.of(2050,8,3))));


//// size
        System.out.println(t1.size());
        System.out.println("");


        //get first element
        System.out.println(t1.peek());
        System.out.println("");




/// retrieve queue
        while(!t1.isEmpty()){

            System.out.println(t1.remove());
        }
        System.out.println("");


        System.out.println(t1.remove());
        System.out.println("");


        while(!t1.isEmpty()){

            System.out.println(t1.remove());
        }
        System.out.println("");



 */


        String[] array = new String[6];

        array[0] = "1. Add a new Task";
        array[1] = "2. View the Task";
        array[2] = "3. Remove Task";
        array[3] = "4. Amount Of Task";
        array[4] = "5. Space left in Queue";
        array[5] = "6. Exit";

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("");

        int number;

        System.out.println("Enter number in menu: ");
        number = keyboard.nextInt();


        if (number < 0 || number > array.length) {

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

                    t1.add(String.valueOf(new Task(owner, description, LocalDate.of(2060, 9, 13))));


                while (!t1.isEmpty()) {

                    System.out.println(t1.remove());
                }

                break;

            case 2:

                while (!t1.isEmpty()) {

                    System.out.println(t1.remove());
                }
                break;

            case 3:

                System.out.println("Task that was removed"+t1.remove());
                System.out.println("Congratulations on removing task");
                System.out.println("");

                while (!t1.isEmpty()) {

                    System.out.println(t1.remove());

                }

                break;


            case 4:
                System.out.println("Number of Task: "+t1.size());


                break;

            case 5:

                int numberLeft = size - t1.size();
                System.out.println("Number of task left: "+numberLeft);

                break;

            case 6:
                break;
        }


    }
}
