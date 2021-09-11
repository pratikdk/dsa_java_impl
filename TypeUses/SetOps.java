import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetOps {

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(3);
        s1.add(2);
        s1.add(6);

        // s1.add(e)
        // s1.addAll(c)
        // s1.remove(o)
        // s1.removeAll(c)
        // s1.removeIf(filter)
        // s1.contains(o)
        // s1.containsAll(c)
        // s1.isEmpty()
        // s1.size()
        // s1.iterator()
        // s1.forEach(action);
        // s1.toArray(a)
        // s1.toString()

        for (Integer i: s1) {
            System.out.println(i);
        }

        Iterator<Integer> iter = s1.iterator();
        while (iter.hasNext()) {
            Integer i = iter.next();
            System.out.println(i);
        }
    }
    
}
