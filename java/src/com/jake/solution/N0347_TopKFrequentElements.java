package com.jake.solution;

import java.util.HashMap;
import java.util.Map;

public class N0347_TopKFrequentElements {

    // sort by count
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        int[] uniqueNums = new int[map.size()];
        int[] count = new int[map.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            uniqueNums[idx] = entry.getKey();
            count[idx] = entry.getValue();
            idx++;
        }

        for (int i = 0; i < uniqueNums.length; i++) {
            int max = i;
            for (int j = i + 1; j < uniqueNums.length; j++) {
                if (count[j] > count[max]) {
                    max = j;
                }
            }
            int temp = uniqueNums[i];
            uniqueNums[i] = uniqueNums[max];
            uniqueNums[max] = temp;
            temp = count[i];
            count[i] = count[max];
            count[max] = temp;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = uniqueNums[i];
        }

        return result;
    }

    // TODO optimize
}
