package demo51_100;

public class Demo59
{
    //深搜
    public int numIslands(char[][] grid)
    {
        if(grid.length==0) return 0;

        int result = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j]=='1')
                {
                    ++result;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j)
    {
        grid[i][j]='x';
        if(i-1>=0 && grid[i-1][j]=='1') dfs(grid,i-1,j);
        if(i+1<grid.length && grid[i+1][j]=='1') dfs(grid,i+1,j);
        if(j-1>=0 && grid[i][j-1]=='1') dfs(grid,i,j-1);
        if(j+1<grid[0].length && grid[i][j+1]=='1') dfs(grid,i,j+1);
    }
}
