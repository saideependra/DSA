class Solution {
    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};

    public void dfs(char[][] grid , int i,int j){
        int m = grid.length;
        int n = grid[0].length;

        grid[i][j] = '0';

        for(int p = 0;p < 4; p++){
            int row = i + x[p];
            int col = j + y[p];

            if(row>=0 && row<m && col>=0 && col<n && grid[row][col]=='1'){
                dfs(grid,row,col);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
        
    }
}