import java.util.ArrayList;

public class RatInMaze4Move {

	public static void findPathHelp(int i, int j, int[][] m, int n, ArrayList<String> ans, int vis[][], String move, int[] di, int dj[]) {
        if(i==n-1 && j==n-1){
            ans.add(move);
            return;
        }       
         String dir = "DLRU";
         for(int ind = 0;ind<4;ind++) {
        	  int nexti = i + di[ind];
        	  int nextj = j + dj[ind];
        	  if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && vis[nexti][nextj]==0 && m[nexti][nextj]==1) {
        		  vis[i][j] = 1;
        		  findPathHelp(nexti, nextj, m, n, ans, vis, move+dir.charAt(ind), di, dj);
        		  vis[i][j] = 0;
        	  }
          }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                vis[i][j] = 0;
            }
        }
        int di[] = {1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0]==1)findPathHelp(0, 0, m, n, ans, vis, "", di, dj);
        else ans.add("-1");
        return ans;
    }
	 public static void main(String[] args) {
		    int board[][] = {
	            {1,0,0,0},
	            {1,1,0,1},
	            {1,1,0,0},
	            {0,1,1,1},
	            };
	       ArrayList<String> result = findPath(board, 4);
	       System.out.println(result);
	}

}
