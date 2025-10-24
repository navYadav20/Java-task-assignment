package Java_Questions;

/**
    Java Question 7:  Write a program that take the command line input and print all received inputs

    time taken - 10 mins

 */

/**
        How to run
        1. Click  Ques7 & select "Edit Configurations"
        2. Find the field labeled "Program arguments"
        3. Type your test inputs into this box. For example: hello world 123 "this is one argument"
 */
public class Ques7 {

    public static void main(String[] args) {
        System.out.println(" Java Question 7: Command Line Inputs ");

        // The 'args' array contains all command line arguments.

        // error handling
        if (args == null || args.length == 0) {
            System.out.println("No command line arguments were provided.");
        } else {
            // arguments provided & print the count.
            System.out.println("Received " + args.length + " command line argument");

            // Loop through the 'args' array and print each
            for (int i = 0; i < args.length; i++) {
                System.out.println("Arg[" + i + "]: " + args[i]);
            }
        }
    }
}
