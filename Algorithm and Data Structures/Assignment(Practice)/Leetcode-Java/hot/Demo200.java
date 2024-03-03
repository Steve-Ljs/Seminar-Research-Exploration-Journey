package hot;

public class Demo200
{
    public int numIslands(char[][] grid)
    {
        int result = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1')
                {
                    findGrid(grid, i, j);
                    ++result;
                }
            }
        }
        return result;
    }

    private void findGrid(char[][] grid, int i, int j)
    {
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') findGrid(grid, i - 1, j);
        if (i + 1 < grid.length && grid[i + 1][j] == '1') findGrid(grid, i + 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == '1') findGrid(grid, i, j - 1);
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') findGrid(grid, i, j + 1);
    }
}
