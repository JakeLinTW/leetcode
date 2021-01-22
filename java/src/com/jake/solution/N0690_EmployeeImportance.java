package com.jake.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0690_EmployeeImportance {

    // TODO optimize
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) {
            return 0;
        }

        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(id);
        int ans = 0;
        while (!list.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            for (Integer i : list) {
                Employee employee = map.get(i);
                ans += employee.importance;
                temp.addAll(employee.subordinates);
            }
            list = temp;
        }
        return ans;
    }

    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
