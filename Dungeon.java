package org.example;

class Dungeon {
    static int minEnergy(int grid[][], int row, int column)
    {
        int dp[][] = new int[row][column];
        int m = row, n = column;

        dp[m - 1][n - 1] = grid[m - 1][n - 1] > 0 ? 1 : Math.abs(grid[m - 1][n - 1]) + 1;

        for (int i = m - 2; i >= 0; i--)
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - grid[i][n - 1], 1);

        for (int j = n - 2; j >= 0; j--)
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - grid[m - 1][j], 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int min_points_on_exit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min_points_on_exit - grid[i][j], 1);
            }
        }

        return dp[0][0];
    }

    public static void main(String args[])
    {
        int[][] grid = { { -2, -3, 3 },
                { -5, -10, 1 },
                { 10, 30, -5 } };
        int row = 3, column = 3;
        System.out.println("Minimum energy required: " + minEnergy(grid, row, column));
    }
}