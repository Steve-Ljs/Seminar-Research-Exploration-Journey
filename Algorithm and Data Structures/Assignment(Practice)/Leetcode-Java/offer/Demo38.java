package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Demo38 {

    List<String> result = new LinkedList<>();
    char[] sequent;

    public String[] permutation(String s) {
        sequent = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }

    private void dfs(int height) {
        if (height == sequent.length - 1) {
            result.add(String.valueOf(sequent));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        //选择列表
        for (int i = height; i < sequent.length; i++) {
            //对重复的进行剪枝
            if (set.contains(sequent[i])) continue;
            set.add(sequent[i]);
            exch(i, height);
            dfs(height + 1);
            exch(i, height);
        }
    }

    private void exch(int i, int j) {
        char temp = sequent[i];
        sequent[i] = sequent[j];
        sequent[j] = temp;
    }
}
