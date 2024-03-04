package hot;

import java.util.LinkedList;
import java.util.List;

public class Demo22
{
    private List<String> result = new LinkedList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public List<String> generateParenthesis(int n)
    {
        if(n==0) return result; //n==0,返回的是空集合,不是空字符串
        dfs(n, n);//左括号个数，右括号个数开始都为n
        return result;
    }

    public void dfs(int leftCount, int rightCount)
    {
        if(rightCount<leftCount) return; //限定条件 说明)比(多
        if(rightCount==0 && leftCount==0) result.add(stringBuilder.toString());

        if(leftCount>0)//限定条件 说明(用完了
        {
            stringBuilder.append('(');
            dfs(leftCount-1,rightCount);//往左走，即往结果加个（
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);//回到上一层,父节点
        }
        if(rightCount>0) //限定条件 说明)用完了
        {
            stringBuilder.append(')');
            dfs(leftCount,rightCount-1);//往右走，即往结果加个）
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);//回到上一层,父节点
        }
    }
}
