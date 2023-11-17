
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class treeSet {

    public static void main(String[] args) throws FileNotFoundException{

        TreeSet<String> fileWordSet = new TreeSet<String>();

    
        try{
            File file = new File("/Users/calla/Documents/Fall 2023 School/SoftwareConst/CodingWork/HW3/text.txt");
            Scanner infile = new Scanner(file);

            while (infile.hasNextLine()){
                fileWordSet.add(infile.next());
            }

            infile.close();

    } catch(FileNotFoundException e){
        System.out.println("File not found");
    }

    System.out.println();
    System.out.println("Words from file sorted:");
    for(String word: fileWordSet)
        System.out.println(word + " ");
    
    
}
}
