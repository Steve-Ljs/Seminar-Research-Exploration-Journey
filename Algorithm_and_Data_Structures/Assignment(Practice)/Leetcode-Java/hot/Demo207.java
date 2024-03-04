package hot;

import java.util.*;

public class Demo207
{
    private Map<Integer, List<Integer>> graph;
    private boolean[] marked;
    private boolean[] cycle;
    private boolean hasCycle;

    public void createGraph(int numCourses, int[][] prerequisites)
    {
        //存储点和他们的邻接边
        graph = new HashMap<>(numCourses);
        //初始化图
        for (int i = 0; i < numCourses; i++) graph.put(i, new LinkedList<>());
        //添加有向边
        for (int i = 0; i < prerequisites.length; i++) graph.get(prerequisites[i][1]).add(prerequisites[i][0]);

        //标记数组
        marked = new boolean[numCourses];
        //负责判断是否有环的临时数组
        cycle = new boolean[numCourses];
    }

    /**
     * 拓扑排序相关问题
     * 有向图,判断是否有环
     * 构造图,dfs判断即可
     */
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        createGraph(numCourses,prerequisites);

        for (int i = 0; i < numCourses; i++)
        {
            //以没标记过的顶点作为某个根节点进行深搜
            if (!marked[i]) dfs(i);
        }
        //无环则可上课
        return !hasCycle;
    }

    private void dfs(int v)
    {
        //顶点标记为已访问
        marked[v] = true;
        cycle[v] = true;
        for (Integer w : graph.get(v))
        {
            if(hasCycle) return;//为了避免有环还在不断寻找
            if (!marked[w])
            {
                dfs(w);
            }
            else if(cycle[w])
            {
                hasCycle = true;
                return;
            }
        }
        cycle[v] = false;
    }
}
