package demo51_100;

import java.util.*;

public class Demo61
{
    /*
    先构成有向图,然后判断有无环即可
     */
    private boolean[] marked;
    private boolean[] pathTo;
    private boolean hasLoop;

    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        marked = new boolean[numCourses];
        pathTo = new boolean[numCourses];

        Map<Integer,List<Integer>> G=createGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++)
        {
            if(!marked[i]) dfs(G, i);
        }
        return !hasLoop;
    }

    private void dfs(Map<Integer, List<Integer>> G, int v)
    {
        marked[v] = true;
        pathTo[v] = true;
        for (Integer w : G.get(v))
        {
            if(hasLoop) return;
            if(!marked[w]) dfs(G,w);
            else if(pathTo[w])
            {
                hasLoop = true;
                return;
            }
        }
        pathTo[v] = false;
    }

    private Map<Integer, List<Integer>> createGraph(int numCourses, int[][] prerequisites)
    {
        Map<Integer, List<Integer>> G = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
        {
            G.put(i, new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++)
        {
            int pre = prerequisites[i][1];
            int course = prerequisites[i][0];
            G.get(pre).add(course);
        }
        /*for (Integer integer : G.keySet())
        {
            System.out.println(integer+" "+G.get(integer));
        }*/
        return G;
    }

    public static void main(String[] args)
    {
//        int[][] prerequisites = {{2,1},{3,2},{4,2},{5,3},{6,3},{6,4}};
//        new Demo61().canFinish(5, prerequisites);
        int[][] prerequisites = {{1,0}};
        new Demo61().canFinish(2, prerequisites);
    }
}
