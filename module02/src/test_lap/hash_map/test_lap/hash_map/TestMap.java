package test_lap.hash_map.test_lap.hash_map;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
//        Map<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("Quoc Khanh", 22);
//        hashMap.put("Duc Dinh", 21);
//        hashMap.put("Thanh Thien", 20);
//        hashMap.put("Duc Thang", 21);
//        System.out.println(hashMap);
//        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
//        System.out.println(treeMap);
//
//        Map<Integer, String> integers = new HashMap<>();
//        integers.put(1,"Khanh");
//        integers.put(5,"Khanh");
//        integers.put(8,"Khanh");
//        integers.put(2,"Khanh");
//        integers.put(0,"Khanh");
//        Map<Integer, String> treeMap1 = new TreeMap<>(integers);
//        System.out.println(treeMap1);
//        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
//        linkedHashMap.put("Quoc Khanh", 22);
//        linkedHashMap.put("Duc Dinh", 21);
//        linkedHashMap.put("Thanh Thien", 20);
//        linkedHashMap.put("Duc Thang", 21);
//        linkedHashMap.get("Quoc Khanh");
//        for (Map.Entry<String, Integer> l: linkedHashMap.entrySet()) {
//            System.out.println(l.getKey() + " " + l.getValue());
//        }
        Map<String, Integer> map = new HashMap<>();
        map.put("Khanh1", 1);
        map.put("Khanh5", 5);
        map.put("Khanh7", 7);
        map.put("Khanh0", 0);
        map.put("Khanh11", 11);
        map.put("Khanh20", 20);
        Set<Integer> set = new TreeSet<>(map.values());
        for (int s: set) {
            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                if ( entry.getValue().equals(s)){
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
            }
        }
    }
}
