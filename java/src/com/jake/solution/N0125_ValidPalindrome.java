package com.jake.solution;

public class N0125_ValidPalindrome {

    // two pointer ( compare char ASCII number )
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        int p1 = 0;
        int p2 = chars.length - 1;
        while (p1 < p2) {
            if (!((48 <= chars[p1] && 57 >= chars[p1]) || ('A' <= chars[p1] && 'Z' >= chars[p1]) || ('a' <= chars[p1] && 'z' >= chars[p1]))) {
                p1++;
                continue;
            }
            if (!((48 <= chars[p2] && 57 >= chars[p2]) || ('A' <= chars[p2] && 'Z' >= chars[p2]) || ('a' <= chars[p2] && 'z' >= chars[p2]))) {
                p2--;
                continue;
            }
            if (String.valueOf(chars[p1]).equalsIgnoreCase(String.valueOf(chars[p2]))) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }
        return true;
    }

    // two pointer ( using Character to compare char ASCII number )
    public boolean isPalindrome2(String s) {
        char[] chars = s.toCharArray();

        int p1 = 0;
        int p2 = chars.length - 1;
        while (p1 < p2) {
            if (!Character.isLetterOrDigit(chars[p1])) {
                p1++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[p2])) {
                p2--;
                continue;
            }
            if (Character.compare(Character.toLowerCase(chars[p1]), Character.toLowerCase(chars[p2])) == 0) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }
        return true;
    }

    // two pointer optimize ( using Character to compare char ASCII number )
    public boolean isPalindrome3(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            if (Character.compare(Character.toLowerCase(s.charAt(left)), Character.toLowerCase(s.charAt(right))) == 0) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    // create new ASCII map
    public boolean isPalindrome4(String s) {
        char[] letterOrDigit = new char[256];
        for (int i = 0; i < 10; i++) {
            letterOrDigit[i + '0'] = (char) (1 + i);
        }

        for (int i = 0; i < 26; i++) {
            letterOrDigit[i + 'a'] = letterOrDigit[i + 'A'] = (char) (11 + i);
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && letterOrDigit[chars[left]] == 0)
                left++;
            while (left < right && letterOrDigit[chars[right]] == 0)
                right--;

            char leftChar = letterOrDigit[chars[left]];
            char rightChar = letterOrDigit[chars[right]];
            if (leftChar == rightChar) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
