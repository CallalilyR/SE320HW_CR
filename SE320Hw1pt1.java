/*
1. (3points) Write a Java program that prompts the user to enter two integers and displays their sum. Use exception handling to prompt the user for reading the number again if the input is incorrect.
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class SE320Hw1pt1{

    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

/* 
    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
*/

    public static void main(String[] args) {

        
        Scanner input = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;

        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter the first integer:");
                num1 = input.nextInt();

                while(!validInput){
                    try{
                        System.out.println("Enter the second integer:");
                        num2 = input.nextInt();
                        validInput = true; // Input is valid, exit the loop

                    }catch(InputMismatchException e){
                        System.out.println("Invalid input. Please enter valid integers.");
                        input.next();  // Clear the invalid input
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid integers.");
                input.next();  // Clear the invalid input
            }
        }

        int result = sum(num1, num2);
        System.out.println(num1 + " + " + num2 + " is " + result);



        // close the scanner
        System.out.println("Closing Scanner...");
        input.close();
        System.out.println("Scanner Closed.");
           
    }
}

