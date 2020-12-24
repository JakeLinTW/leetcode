package com.jake.solution;

import java.util.HashMap;
import java.util.Map;

public class N0299_BullsAndCows {

    // using hash map, count a first and then count b
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] sArr = secret.toCharArray();
        for (char s : sArr) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        char[] gArr = guess.toCharArray();
        for (int i = 0; i < gArr.length; i++) {
            if (map.containsKey(gArr[i]) && map.get(gArr[i]) > 0) {
                if (sArr[i] == gArr[i]) {
                    map.put(gArr[i], map.get(gArr[i]) - 1);
                    a++;
                }
            }
        }

        for (int i = 0; i < gArr.length; i++) {
            if (map.containsKey(gArr[i]) && map.get(gArr[i]) > 0) {
                if (sArr[i] != gArr[i]) {
                    map.put(gArr[i], map.get(gArr[i]) - 1);
                    b++;
                }
            }
        }

        return new StringBuilder(String.valueOf(a)).append("A").append(b).append("B").toString();
    }
    
    // TODO optimize
}
