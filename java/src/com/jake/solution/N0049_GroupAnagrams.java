package com.jake.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class N0049_GroupAnagrams {

    // using sorted chars for key
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }
    
    // using sorted chars for key optimize
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
    
    // using character count for key
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] count = new int[26];
            str.chars().forEach(e -> {
                count[e - 'a'] += 1;
            });

            StringBuilder keyBuilder = new StringBuilder();
            for (int c : count) {
                keyBuilder.append("#");
                keyBuilder.append(c);
            }

            String key = keyBuilder.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
