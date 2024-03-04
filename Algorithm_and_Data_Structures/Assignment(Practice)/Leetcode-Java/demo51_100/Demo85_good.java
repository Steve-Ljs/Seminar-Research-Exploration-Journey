package demo51_100;

import java.util.*;

public class Demo85_good
{
    /*
    该方法还未完全理解,后续再观察
    并查集的方法
    parents中,key存子,value存父
    values存储的是每个节点对应的值
    例如之后要计算a/b,那么先计算b到根节点的值,再/a到根节点的值即可
     */
    Map<String, String> parents = new HashMap<>();
    Map<String, Double> values = new HashMap<>();

    public void add(String x)
    {
        if (!parents.containsKey(x))
        {
            parents.put(x, x);
            values.put(x, 1.0);
        }
    }

    public void union(String parent, String child, double value)
    {
        add(parent);
        add(child);
        String p1 = find(parent);
        String p2 = find(child);
        if (!p1.equals(p2))
        {
            parents.put(p2, p1);
            /*这一步要小心
            处理的是父节点,可以画图分析
            假如开始有a/b=2  c/d=3,再加入一个d/b=5
            则a的父节点是c,且a的值为5*3/2,这样是正确的
            因为如果计算a/b,则计算cal(b)/cal(a),结果还是2
            计算d/b,则计算cal(b)/cal(d),正确
            而c/a结果为5*3/2,符合逻辑
             */
            values.put(p2, value * (values.get(parent) / values.get(child)));
        }
    }

    public String find(String x)
    {
        while (parents.get(x) != x)
        {
            x = parents.get(x);
        }
        return x;
    }

    //该函数是从此节点到根节点的值相乘
    //代表的是根节点(例如)a/x的值
    public double cal(String x)
    {
        double v = values.get(x);
        while (parents.get(x) != x)
        {
            x = parents.get(x);
            v *= values.get(x);
        }
        return v;
    }


    //用并查集
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        for (int i = 0; i < equations.size(); i++)
        {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++)
        {
            String c1 = queries.get(i).get(0);
            String c2 = queries.get(i).get(1);

            if (!parents.containsKey(c1) || !parents.containsKey(c2))
            {
                result[i] = -1;
            } else if (c1.equals(c2))
            {
                result[i] = 1;
            } else
            {
                String p1 = find(c1);
                String p2 = find(c2);
                if (!p1.equals(p2)) result[i] = -1;
                //要计算c1/c2,即为计算[(a/c2)/(a/c1)]
                else result[i] = cal(c2) / cal(c1);
            }
        }

        return result;
    }

    //构造图+dfs
    /*public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        //初始化图
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++)
        {
            String v = equations.get(i).get(0);
            String w = equations.get(i).get(1);
            double weighted = values[i];
            Map<String, Double> edgeV = graph.getOrDefault(v, new HashMap<>());
            edgeV.put(w, weighted);
            graph.put(v, edgeV);
            //反向添加b->a
            Map<String, Double> edgeW = graph.getOrDefault(w, new HashMap<>());
            edgeW.put(v, 1 / weighted);
            graph.put(w, edgeW);
        }

        double[] result = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries)
        {
            String v = query.get(0);
            String w = query.get(1);
            result[i++] = dfs(graph, v, w,new HashSet<>(),1);
        }
        return result;
    }


    private double dfs(Map<String, Map<String, Double>> graph, String v, String w,Set<String> visited,double value)
    {
        if(!graph.containsKey(v) ||! graph.containsKey(w)) return -1.0;
        if(v.equals(w)) return 1.0;//必须有而且在上一条后面,避免出现x/x这种
        //v的所有相邻边
        visited.add(v);
        for (String s : graph.get(v).keySet())
        {
            if(!visited.contains(s))
            {
                if(s.equals(w)) return value *graph.get(v).get(s);
                else
                {
                    double ans = dfs(graph, s, w, visited, value * graph.get(v).get(s));
                    if(ans!=-1) return ans;//很重要的代码
                }
            }
        }
        //不同在于这里return了一个值,而传统的dfs直接return
        return -1.0;
    }
    */
    public static void main(String[] args)
    {
        List<List<String>> equations = new LinkedList<>();
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        temp.add("a");
        temp.add("b");
        List<String> temp1 = new LinkedList<>();
        temp1.add("b");
        temp1.add("c");
        equations.add(temp);
        equations.add(temp1);

        List<String> temp3 = new LinkedList<>();
        temp3.add("a");
        temp3.add("c");
        List<String> temp4 = new LinkedList<>();
        temp4.add("b");
        temp4.add("a");
        queries.add(temp3);
        queries.add(temp4);

        new Demo85_good().calcEquation(equations, values, queries);


    }
}
