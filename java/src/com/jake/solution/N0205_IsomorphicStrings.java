package com.jake.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N0205_IsomorphicStrings {

    // use numbers to represent characters
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> scToInt = new HashMap<Character, Integer>();
        Map<Character, Integer> tcToInt = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!scToInt.containsKey(sc)) {
                scToInt.put(sc, i);
            }
            if (!tcToInt.containsKey(tc)) {
                tcToInt.put(tc, i);
            }
            if (!scToInt.get(sc).equals(tcToInt.get(tc))) {
                return false;
            }
        }
        return true;
    }

    // use numbers to represent characters optimize
    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Integer> scToInt = new HashMap<Character, Integer>();
        Map<Character, Integer> tcToInt = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (scToInt.get(sc) != tcToInt.get(tc)) {
                return false;
            }
            // if out of int cache ( -128~127 ),
            // autoboxing will create two different integer object
            Integer integer = Integer.valueOf(i);
            scToInt.put(sc, integer);
            tcToInt.put(tc, integer);
        }
        return true;
    }

    // mapping char
    public boolean isIsomorphic3(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> replaced = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) != value) {
                    return false;
                }
            } else {
                if (replaced.contains(value)) {
                    return false;
                }
                map.put(key, value);
                replaced.add(value);
            }
        }
        return true;
    }

    // use two int array to mapping s and t
    public boolean isIsomorphic4(String s, String t) {
        int[] sArr = new int[256];
        int[] tArr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sArr[s.charAt(i)] != tArr[t.charAt(i)]) {
                return false;
            }
            sArr[s.charAt(i)] = i + 1;
            tArr[t.charAt(i)] = i + 1;
        }
        return true;
    }

    // use one int array to mapping s and t
    public boolean isIsomorphic5(String s, String t) {
        int[] array = new int[512];
        for (int i = 0; i < s.length(); i++) {
            int sIdx = s.charAt(i);
            int tIdx = t.charAt(i) + 256;
            if (array[sIdx] != array[tIdx]) {
                return false;
            }
            array[sIdx] = i + 1;
            array[tIdx] = i + 1;
        }
        return true;
    }

    // use char array to compare two string
    public boolean isIsomorphic6(String s, String t) {
        char[] scArr = new char[256];
        char[] tcArr = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (scArr[sc] != tcArr[tc]) {
                return false;
            }
            scArr[sc] = tc;
            tcArr[tc] = tc;
        }
        return true;
    }

    // use char array to compare two string optimize
    public boolean isIsomorphic7(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        char[] sm = new char[256];
        char[] tm = new char[256];
        for (int i = 0, max = tArr.length; i < max; i++) {
            char sc = sArr[i];
            char tc = tArr[i];

            if (sm[sc] == 0 && tm[tc] == 0) {
                sm[sc] = tc;
                tm[tc] = tc;
            } else if (sm[sc] != tm[tc]) {
                return false;
            }
        }
        return true;
    }
}
