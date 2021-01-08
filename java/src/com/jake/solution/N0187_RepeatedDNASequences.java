package com.jake.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class N0187_RepeatedDNASequences {

    // use hash set and two pointer
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        for (int left = 0, right = 10; right <= s.length(); right++, left++) {
            String seq = s.substring(left, right);
            if (!set.add(seq)) {
                ans.add(seq);
            }
        }
        return ans.stream().distinct().collect(Collectors.toList());
    }
    
    // use hash map and two pointer
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList<String>();
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for (int left = 0, right = 10; right <= s.length(); right++, left++) {
            String seq = s.substring(left, right);
            if (!map.containsKey(seq)) {
                map.put(seq, true);
            } else if (map.get(seq)) {
                ans.add(seq);
                map.put(seq, false);
            }
        }
        return ans;
    }    

    // use hash set and two pointer optimize
    public List<String> findRepeatedDnaSequences3(String s) {
        Set<String> find = new HashSet<String>();
        Set<String> ans = new HashSet<String>();
        for (int left = 0, right = 10; right <= s.length(); right++, left++) {
            String seq = s.substring(left, right);
            if (!find.add(seq)) {
                ans.add(seq);
            }
        }
        return new ArrayList<String>(ans);
    }
    
    // TODO optimize
}
