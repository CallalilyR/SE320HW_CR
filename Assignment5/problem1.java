package HW5;
import java.time.LocalDate;

public class problem1 {
    public static void main(String[] args){
    
        System.out.println("How many days has it been since my birthday");
        System.out.println("\nMy Birthday is August 21, 2002 or 08/21/2002");

        int birthYr = 2002;
        int birthDay = 21;
        int birthMth = 8; // Note: months in java.time are 1-based

        Day myBday = new Day(birthYr, birthMth, birthDay);

        LocalDate currentDate = LocalDate.now();
        Day today = new Day(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());

        int daysPassed = today.daysFrom(myBday);

        System.out.println("Today is " + currentDate.getMonth() + + currentDate.getDayOfMonth() + currentDate.getYear());
        System.out.println("Days since my birthday: " + daysPassed);
    }
        
}
