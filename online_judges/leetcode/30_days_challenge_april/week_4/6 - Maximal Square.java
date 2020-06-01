class Solution {
    public int maximalSquare(char[][] M) {
        int ans = 0;
        int n = M.length;
        if (n == 0 ) return 0;
        int m = M[0].length;
        
        int S[][] = new int[n][m];      
          
        for(int i = 0; i < n; i++) 
            S[i][0] = M[i][0] - '0'; 
      
        
        for(int j = 0; j < m; j++) 
            S[0][j] = M[0][j] - '0'; 
          
        
        for(int i = 1; i < n; i++) { 
            for(int j = 1; j < m; j++) { 
                if(M[i][j] == '1')  
                    S[i][j] = Math.min(S[i][j-1], 
                                Math.min(S[i-1][j], S[i-1][j-1])) + 1; 
                else
                    S[i][j] = 0; 
            }  
        }
        
        ans = S[0][0];  
        for(int i = 0; i < n; i++) { 
            for(int j = 0; j < m; j++) { 
                ans  = Math.max(ans, S[i][j]);    
            }                  
        }     
        
        return ans * ans;
    }
}