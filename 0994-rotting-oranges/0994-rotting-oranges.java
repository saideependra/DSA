class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshcount = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c]==2){
                    q.add(new int[]{r,c});
                }else if(grid[r][c]==1){
                    freshcount++;
                }

            }
        }
        if(freshcount==0){
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty()){
            int levelsize = q.size();
            boolean rootedThisLevel = false;

            for(int i = 0; i < levelsize ; i++){
                int cell[] = q.poll();
                int r = cell[0], c = cell[1];

                for(int[] dir: directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshcount--;
                        q.add(new int[]{nr, nc});
                        rootedThisLevel = true;
                    }
                }

            }
            if(rootedThisLevel){
                minutes++;
            }
        }
        return freshcount == 0 ? minutes : -1;
    }
}