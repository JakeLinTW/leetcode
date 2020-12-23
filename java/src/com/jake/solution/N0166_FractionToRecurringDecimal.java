package com.jake.solution;

import java.util.ArrayList;
import java.util.List;

public class N0166_FractionToRecurringDecimal {

    // TODO optimize
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = false;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            isNegative = true;
        }

        long integer = Math.abs((long) (numerator / denominator));
        long decimal = Math.abs((long) (numerator % denominator));

        StringBuilder sb = new StringBuilder();
        if (isNegative) {
            sb.append("-");
        }
        sb.append(integer);
        if (decimal == 0) {
            return sb.toString();
        }

        List<Long> list = new ArrayList<Long>();
        List<Long> temp = new ArrayList<Long>();
        while (decimal != 0 && !list.contains(decimal) && temp.size() < 1000) {
            list.add(decimal);
            decimal *= 10;
            temp.add(decimal / denominator);
            decimal %= denominator;
        }
        sb.append(".");
        boolean isRepeat = false;
        for (int i = 0; i < list.size(); i++) {
            if (!isRepeat && list.get(i).equals(decimal)) {
                sb.append("(");
                isRepeat = true;
            }
            sb.append(Math.abs(temp.get(i)));
        }

        if (isRepeat) {
            sb.append(")");
        }

        return sb.toString();
    }
}
