package demo51_100;

import java.util.LinkedList;
import java.util.List;

/*
对于一个字符串，在任何时候如果')'的个数多于左括号，
则说明从开始到现在位置必然可以删除一个')'．而这段子串可能包含多个')'，删除哪一个呢？
当然删除任何一个都可以．例如对于()())，
从开头到s[4]位置构成的子串多了一个右括号，因此我们需要删掉一个，而这个子串有三个右括号，
但是只会产生２个结果，也就是会有一个重复值．所以在删除括号的时候，为保证不会产生重复值，需要记录一个最后删除的位置，
这样可以使得在接下来删除的时候只删除这个位置之后的值．这样我们可以使得当前这一段子串不再包含多余的右括号了．
这样我们可以删除了一个右括号之后合法的子串与后面还没有检查过的子串组成一个新的字符串重新开始检查．直到不再含有非法的右括号．

但是还有一种情况是包含了多余的左括号，一种直观的方法是从右向左再按照上面的方法处理一遍左括号．但是将数组逆置之后就可以重用上面的算法了．
所以总的思路就是先对字符串进行处理使得其不再含有非法右括号，然后将其翻转以后再检查是否含有非法的左括号
*/
class Demo77_look
{
    public List<String> removeInvalidParentheses(String s)
    {
        List<String> result = new LinkedList<>();
        dfs(s, result, ')', 0);//ch代表了刚开始检查的是')'的合理性,last记录了最后删除的位置
        return result;
    }

    private void dfs(String s, List<String> result, char ch, int last)
    {
        for (int i = 0, count = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == ')')  //让count为要检查的那个ch的数量
            {
                if(s.charAt(i)==ch) ++count;
                else --count;
            }
            if(count<=0) continue;//说明ch不多,那就没关系,少了也没有关系,因为后面会反过来检查

            /*
            last为最后一个处理过的字符
            s[j - 1] != ch的原因是,()())的情况中,最后一次的括号不用再删除一次了,因为会重复
            j==last是为了如果一开始就是')',j-1不存在的时候
            把多余的)截开了,并且几种可能的情况都继续
            不同情况的j(即last)在不同位置,也就表明接下来')'处理位置的不同
                substr(start,length)如果没有指定length，则子字符串将延续到字符串的结尾。
             */
            for (int j = last; j <=i ; j++)
            {
                if (s.charAt(j) == ch && (j == last || s.charAt(j-1) != ch))
                    dfs(s.substring(0, j) + s.substring(j + 1),result, ch, j);
            }
            return;
        }

        //reverse(s.begin(), s.end());
        if (ch == ')') //再检查'('是否是多出来的
            dfs(s,result, '(', 0);
        result.add(s);
    }
    /*void DFS(string s, char ch, int last,vector<string> & result)
    {
        for (int i = 0, count = 0; i != s.size(); ++i)
        {
            if (s[i] == '(' || s[i] == ')')
                s[i] == ch ? ++count : --count;
            if (count <= 0) continue; //没反转前,左括号多了不打紧,但是')'一多,就要开始清理了
            for (int j = last; j <= i; ++j)//last为最后一个处理过的字符
            {
                //s[j - 1] != ch的原因是,()())的情况中,最后一次的括号不用再删除一次了,因为会重复
                if (s[j] == ch && (j == last || s[j - 1] != ch))//j==last是为了如果一开始就是')',j-1不存在的时候
                    DFS(s.substr(0, j) + s.substr(j + 1), ch, j,result);//把多余的)截开了,并且几种可能的情况都继续
                //不同情况的j(即last)在不同位置,也就表明接下来')'处理位置的不同
                //substr(start,length)如果没有指定length，则子字符串将延续到字符串的结尾。
            }
            return;
        }
        reverse(s.begin(), s.end());
        if (ch == ')') //再检查'('是否是多出来的
            return DFS(s, '(', 0,result);
        result.push_back(s);
    }*/
};