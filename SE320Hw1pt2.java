/*
 * 2. (3points) Write a Java program that meets the following requirements:
- Creates an array with 100 randomly chosen integers.
- Prompts the user to enter the index of the array, then displays the corresponding element value. If the specified index is out of bounds, catch the exception and display the message "Out of Bounds".

 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SE320Hw1pt2 {
    

    public static void main(String[] args) {

    int[] intArray = new int[100]; //declares and allocates memory in the array

    Random rd = new Random(); // creating Random object
    
    for (int i = 0; i < intArray.length; i++) {
        intArray[i] = rd.nextInt(); // storing random integers in an array
        System.out.println(intArray[i]); // printing each array element
     }

     Scanner input = new Scanner(System.in);
     int indexInput = 0;
     int indexValue = 0;
     boolean inBounds = false;

     while(!inBounds){
        
        try{
            System.out.println("Enter what index of the array you would like to see...");
            indexInput = input.nextInt();
            indexValue = intArray[indexInput];
            inBounds = true;

        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Input Out of Bounds, please try again");
            //input.next();  // Clear the invalid input
    
        } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid integers.");
                input.next();  // Clear the invalid input
        }
     }

     System.out.println("Integer at index " + indexInput + " is " + indexValue);

      // close the scanner
      System.out.println("Closing Scanner...");
      input.close();
      System.out.println("Scanner Closed.");
         


    }
}
