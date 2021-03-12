package com.jake.solution;

import java.util.HashSet;
import java.util.Set;

public class N0345_ReverseVowelsOfAString {

    // hash set
    public String reverseVowels(String s) {
        char[] result = new char[s.length()];

        int left = 0;
        int right = s.length() - 1;
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        while (true) {
            while (left < s.length() && !set.contains(s.charAt(left))) {
                result[left] = s.charAt(left);
                left++;
            }
            while (right >= 0 && !set.contains(s.charAt(right))) {
                result[right] = s.charAt(right);
                right--;
            }
            if (left > right) {
                break;
            }
            result[left] = s.charAt(right);
            result[right] = s.charAt(left);
            left++;
            right--;
        }
        return new String(result);
    }
    
    // TODO optimize
}
