package niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class JZ27 {
    ArrayList<String> result = new ArrayList<>();
    char[] sequence;

    /*
    回溯法
    */
    public ArrayList<String> Permutation(String str) {
        sequence = str.toCharArray();
        dfs(0);
        Collections.sort(result);
        return result;
    }

    private void dfs(int height) {
        if (height == sequence.length - 1) {
            result.add(String.valueOf(sequence));
            return;
        }

        HashSet<Character> hashSet = new HashSet<>();

        for (int i = height; i < sequence.length; i++) {
            if (hashSet.contains(sequence[i])) continue;

            hashSet.add(sequence[i]);
            exch(i, height);
            dfs(height + 1);
            exch(i, height);
        }
    }

    private void exch(int i, int j) {
        char temp = sequence[i];
        sequence[i] = sequence[j];
        sequence[j] = temp;
    }
}
