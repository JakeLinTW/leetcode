package com.jake.solution;

public class N0717_1BitAnd2BitCharacters {

    // increment pointer
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (i == bits.length - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i++;
            }
        }
        return false;
    }

    // increment pointer optimize
    public boolean isOneBitCharacter2(int[] bits) {
        int i = 0;

        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }

        return i == bits.length - 1;
    }

    // greedy
    public boolean isOneBitCharacter3(int[] bits) {

        // find second-last 0
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.length - i) % 2 == 0;
    }
}
