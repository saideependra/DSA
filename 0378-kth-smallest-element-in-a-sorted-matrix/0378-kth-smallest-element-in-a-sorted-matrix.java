class Solution {
    public int fun(int[][] arr,int n,int m,int guess){
        int row = n-1;
        int col = 0;
        int count =0;
        while(row>=0 && col < m){
            if(arr[row][col]<=guess){
                count += row+1;
                col++;
            }else{
                row--;
            }

        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n =  matrix.length;
        int m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n-1][m-1];

        int res =-1;

        while(high>=low){
            int mid = low+(high-low)/2;
            
            int ans = fun(matrix,n,m,mid);

            if(ans<k){
                low=mid+1; 
            }else{
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
}