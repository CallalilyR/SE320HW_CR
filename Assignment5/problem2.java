package HW5;

import java.util.*;

public class problem2{
/**
 * Removes consecutive duplicates from the given list.
 *
 * preconditions:
 * - input list (lst) should not be null
 * - input list (lst) should not be empty
 * - Elements in the input list must be comparable and be of the same type
 * - the input list (lst) must be mutable
 * - 
 * 
 * @param lst a non-null, mutable list containing elements of the same type.
 * @throws IllegalArgumentException if the input list is null.
 * @throws UnsupportedOperationException if the input list is immutable.
 */

    public static void removeDuplicates(List lst) {
        if (lst == null || lst.size() == 0) return;
        List copy = new ArrayList(lst);
        Iterator elements = copy.iterator();
        Object pre = elements.next();
    
        while(elements.hasNext()) {
            Object nex = elements.next();
            if (pre.equals(nex)) lst.remove(nex);
            else pre = nex;
        }   
    }   
}
