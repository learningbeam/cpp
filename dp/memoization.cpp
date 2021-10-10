class Solution {
public:
    int solve(vector<vector<int>>& grid,int x,int y, int m, int n, vector<vector<int>>&dp){
        if(x<0 || x>=m || y<0 || y>=n) return 10000;
        if(x == m-1 && y==n-1) return grid[x][y];
        if(dp[x][y] != -1) return dp[x][y];
        return dp[x][y] = grid[x][y] + min(solve(grid,x+1,y,m,n,dp), solve(grid,x,y+1,m,n,dp));
    }
    
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m,vector<int>(n,-1));
        return solve(grid,0,0,m,n,dp);
    }
};
