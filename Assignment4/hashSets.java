package HW3;
import java.util.*;


public class hashSets {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Blake");

        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michael");
        set2.add("Ryan");

        System.out.println("Hashset 1");
        for (String s: set1){
            System.out.println(s.toUpperCase() + "");
        }

        System.out.println("HashSet 2");
        for (String s: set1){
            System.out.println(s.toUpperCase() + "");
        }

        HashSet<String> clone = (HashSet<String>)set1.clone();
        clone.addAll(set2);
        System.out.println("Names in hashset 1 OR in hashset 2 (Union)");
        System.out.println(clone);

        clone = (HashSet<String>)set1.clone();
        clone.retainAll(set2);
        System.out.println("Names in hashset 1 AND hashet 2 (Intersection)");
        System.out.println(clone);
        
        clone = (HashSet<String>)set1.clone();
        clone.removeAll(set2);
        System.out.println("Names in hashset 1, but not in hashset 2 (difference)");
        System.out.println(clone);

        
    
    }
    
}
