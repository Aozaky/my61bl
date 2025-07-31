import edu.princeton.cs.algs4.In;

import java.util.*;

public class CodingChallenges {

    /**
     * Return the missing number from an array of length N containing all the
     * values from 0 to N except for one missing number.
     */
    public static int missingNumber(int[] values) {
        Set<Integer> seen = new HashSet<>();
        for (int i : values) {
            seen.add(i);
        }
        for (int i = 0; i <= values.length; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Returns true if and only if s1 is a permutation of s2. s1 is a
     * permutation of s2 if it has the same number of each character as s2.
     */
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> characterCounts = new HashMap<>();

        for (char i: s1.toCharArray()) {
            characterCounts.put(i, characterCounts.getOrDefault(i, 0) + 1);
        }

        for (char i : s2.toCharArray()) {
            if (!characterCounts.containsKey(i) || characterCounts.get(i) == 0) {
                return false;
            }
            characterCounts.put(i, characterCounts.get(i) - 1);
        }
        return true;
    }
}
