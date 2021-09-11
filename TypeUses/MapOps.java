import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class MapOps {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(i, i+1);
        }
        System.out.println(map);

        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map2.put(i, new ArrayList<>());
            if (map2.containsKey(i-1)) {
                map2.get(i).addAll(map2.get(i-1));
            }
            map2.get(i).add(i+1);
        }
        System.out.println(map2);

        // map.put(key, value)
        // map.putIfAbsent(key, value)
        // map.putAll(m);
        // map.get(key)
        // map.getOrDefault(key, defaultValue)
        // map.remove(key)
        // map.remove(key, value)
        // map.replace(key, value)
        // map.replace(key, oldValue, newValue)
        // map.keySet()
        // map.values()
        // map.entrySet()
        // map.containsKey(key)
        // map.containsValue(value)
        // map.isEmpty()
        // map.forEach(action);
        // map.size()
        // map.toString()

        Map<Integer, Integer> m1 = new HashMap<>();

        // map.put(key, value)
        // map.putIfAbset(key, value)
        m1.put(2, 1);
        m1.putIfAbsent(3, 0);

        Map<Integer, Integer> m2 = new HashMap<>();
        // map.putAll(otherMap)
        m2.putAll(m1);

        System.out.println(m1);
        System.out.println(m2);

        // map.get(key)
        System.out.println(m1.get(2));
        System.out.println(m2.get(3));

        // map.getOrDefault(key, defaultValue)
        System.out.println(m1.getOrDefault(4, -1));
        System.out.println(m1);

        // map.remove(key)
        m2.remove(3);
        System.out.println(m2);

        // map.replace(key, newValue)
        // map.replace(key, oldValue, newValue)
        m2.put(3, 0);
        m2.put(4, 0);
        System.out.println(m2);
        m2.replace(3, -1);
        m2.replace(4, 0, -1);
        System.out.println(m2);

        // map.keySet()
        System.out.println(m1);
        System.out.println(m1.keySet());
        Set<Integer> s1 = m1.keySet();
        System.out.println(s1);

        // map.values()
        Collection<Integer> c1 = m1.values();
        List<Integer> l1 = new ArrayList<>(c1);
        System.out.println(c1);
        System.out.println(l1);

        // map.entrySet()
        System.out.println(m1);
        Set<Map.Entry<Integer, Integer>> sm1 = m1.entrySet();
        for (Map.Entry<Integer, Integer> entry: sm1) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry: m1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // map.containsKey()
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsKey(20));

        // map.containsValue()
        System.out.println(m1.containsValue(1));
        System.out.println(m1.containsValue(200));

        // map.size()
        System.out.println(m1.size());

        // map.forEach(action)
        m1.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }
}
