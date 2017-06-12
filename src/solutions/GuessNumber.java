package solutions;

/**
 * Reference to :https://discuss.leetcode.com/topic/51353/simple-dp-solution-with-explanation/2
 * 
 * @author Zhiyuan
 *
 */
public class GuessNumber {
	public int getMoneyAmount(int n) {
        int[][] matrix = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(matrix[i][k-1], matrix[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                matrix[i][j] = i+1==j?i:globalMin;
            }
        }
        return matrix[1][n];
    }
}