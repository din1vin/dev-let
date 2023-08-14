package dl.algorithm.c11hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (groups.containsKey(key)) {
                groups.get(key).add(str);
            } else {
                groups.put(key, new ArrayList<>(List.of(str)));
            }
        }
        return new ArrayList<>(groups.values());
    }
}
