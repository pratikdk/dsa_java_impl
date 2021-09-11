import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ListOps {
    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<>();

        // list.add(e)
        // list.add(index, element);
        // list.addAll(c)
        // list.remove(o)
        // list.remove(index)
        // list.removeIf(filter)
        // list.removeAll(c)
        // list.get(index)
        // list.set(index, element)
        // list.indexOf(o)
        // list.contains(o)
        // list.size()
        // list.isEmpty()
        // list.iterator()
        // list.sort(c);
        // list.subList(fromIndex, toIndex)
        // list.toString()
        // list.toArray()
        // list.forEach(action);

        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
        // list.add()
        l1.add(5);
        l1.add(l1.size(), 6);
        l1.addAll(l1);
        System.out.println(l1);

        // list.remove()
        l1.remove(Integer.valueOf(6));
        l1.remove(l1.size()-1);
        l1.removeAll(Arrays.asList(4));
        System.out.println(l1);
        //l1.removeIf(p -> p == 3);
        l1.removeIf(p -> {
            return p == 3;
        });
        System.out.println(l1);

        // list.get();
        System.out.println(l1.get(l1.size()-1));

        // list.set();
        l1.set(0, 100);
        System.out.println(l1);

        // list.indexOf()
        // list.contains()
        System.out.println(l1.indexOf(100));
        System.out.println(l1.contains(100));
        System.out.println(l1.contains(200));

        // list.isEmpty();
        System.out.println(l1.isEmpty());

        // list.iterator()
        // while loop
        Iterator<Integer> iter =  l1.iterator();
        while (iter.hasNext()) {
            Integer x = iter.next();
            System.out.print(x + " ");
        }
        System.out.println();

        // list.listIterator()
        // while loop
        ListIterator<Integer> iter2 = l1.listIterator();
        while (iter2.hasNext()) {
            Integer x = iter2.next();
            if (x == 1) {
                iter2.add(100);
            }
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(l1);

        // list.sort()
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 2, 9, 1));
        l2.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(l2);

        // list.sublist()
        List<Integer> l3 = l2.subList(1, 3);
        System.out.println(l3);

        // list.toString()
        System.out.println(l3.toString());

        // list.toArray()
        Integer[] arr = new Integer[l3.size()];
        l3.toArray(arr);
        System.out.println(Arrays.toString(arr));

        // list.forEach()
        l1.forEach(c -> {
            System.out.println(c);
        });
    }
}