import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Integer[] ss = new Integer[2];
        // ss[0] = "a";
        // ss[1] = "b";
        System.out.println(Arrays.toString(ss));
        List<Integer> l = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        l.addAll(d);
        System.out.println(l);
    }
}
