package HW3;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class locales {
    public static void main(String[] args) throws ParseException {
       
        NumberFormat nfUK = NumberFormat.getInstance(Locale.UK);
        NumberFormat nfUS = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        nfUK.setMaximumFractionDigits(2);
        
        double number = 12345.678;
        Number numberParsed = nf.parse("12,345.678");

        String sUK = nfUK.format(number);
        String sUS = nfUS.format(number);

        System.out.println("The UK format of number " + number + " is " + sUK);
        System.out.println("The US format of number " + number + " in US currency is " + sUS);
        System.out.println(" '12,345.678' parsed into a number -> " + numberParsed.doubleValue());
    }
    
}
