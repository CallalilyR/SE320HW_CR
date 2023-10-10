import java.util.Scanner;
import java.util.InputMismatchException;

public class Assert {
    
    public static int validInput(){
        
        Scanner input = new Scanner(System.in);
        
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter a number between 0 and 10: ");
                number = input.nextInt();
                validInput = true;
               

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid integers.");
                input.next();  // Clear the invalid input
            }
        }
        
         // close the scanner
      System.out.println("Closing Scanner...");
      input.close();
      System.out.println("Scanner Closed.");
        
        return number;

    }


    public static void main(String[] args) {
        
        int userInput = validInput();

        assert 0 <= userInput && userInput <= 10 : "The entered number is out of range";


        
    }
}
