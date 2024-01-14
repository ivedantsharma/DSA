import java.util.*;

public class hashsetmap {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        //HashSet
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(5);
        if (set.contains(1)) System.out.println("contains");
        if (!set.contains(6)) System.out.println("not contains");
        set.remove(1);
        if (!set.contains(1)) System.out.println("not contain");
        System.out.println(set.size());
        System.out.println(set);
        Iterator it = set.iterator();
        while (it.hasNext()) System.out.println(it.next());

        //HashMap
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",120);
        map.put("US",30);
        map.put("China",150);
        System.out.println(map);
        map.put("China",180);//if key exixt then value will be updated and if key not exist then new key with its value will be added
        System.out.println(map);
        if (map.containsKey("China")) System.out.println("present");
        else System.out.println("not present");
        System.out.println(map.get("China"));
        System.out.println(map.get("indonesia"));
        System.out.println(map.size());
        for (Map.Entry<String,Integer> e : map.entrySet()) {
            System.out.print(e.getKey()+" ");
            System.out.println(e.getValue());
        }
        Set<String> keys = map.keySet();
        for (String key : keys) System.out.println(key + " " + map.get(key));
        map.remove("China");
        System.out.println(map);
    }
}
