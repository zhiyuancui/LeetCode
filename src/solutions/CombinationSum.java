package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	/**
	 * Combination Sum II
	 * Have duplicates
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates,
            int target) {
    
        List<List<Integer>> results = new ArrayList<List<Integer>>();
            
        if (candidates.length < 1) {
            return results;
        }

        List<Integer> path = new ArrayList<Integer>();
        java.util.Arrays.sort(candidates);
        combinationSumHelper(results, path, candidates, target, 0);

        return results;
    }

    private void combinationSumHelper(List<List<Integer>> result, 
           List<Integer> path, int[] candidates, int sum, int pos) {
        if (sum == 0) {
            result.add(new ArrayList<Integer>(path));
        }

        if (pos >= candidates.length || sum < 0) {
            return;
        }

        int prev = -1;
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] != prev) {
                path.add(candidates[i]);
                combinationSumHelper(result, path, candidates, sum - candidates[i], i + 1);
                prev = candidates[i];
                path.remove(path.size()-1);
            }
        }
    }
    
    /**
     * Second Method
     * @param result
     * @param solution
     * @param nums
     * @param start
     * @param target
     */
    private void generate(List<List<Integer>> result, List<Integer> solution, int[] nums, int start, int target ){
        if( target == 0 ){
            result.add(new ArrayList<Integer>( solution ));
        }
        
        if( target < 0 ){
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            if( i != start && nums[i] == nums[i-1] ){
                continue;
            }
            
            solution.add( nums[i] );
            generate(result, solution, nums, i+1, target - nums[i]);
            solution.remove( solution.size() - 1 );
        }
    }
    
    /**
     * Combination Sum
     * No duplicates. but number could repeat
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if( candidates == null || candidates.length == 0 ){
            return result;
        }
        
        Arrays.sort( candidates );
        
        List<Integer> solution = new ArrayList<Integer>();
        generate(result, solution, target, candidates,0);
        return result;
    }
    
    private void generate(List<List<Integer>> result, List<Integer> solution, int target, int[] candidates, int start){
        if( target == 0 ){
            result.add( new ArrayList<Integer>( solution ) );
        }
        
        if( target < 0 ){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if( candidates[i] > target ){
                break;
            }
            solution.add( candidates[i] );
            generate(result, solution, target - candidates[i], candidates, i);
            solution.remove( solution.size() - 1 );
        }
    }
    
    /*The Code on my Desktop will fail with input [1,1]
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
         
         List<List<Integer>> results = new ArrayList<List<Integer>>();
             
         if (candidates.length < 1) {
             return results;
         }

         List<Integer> path = new ArrayList<Integer>();
         java.util.Arrays.sort(candidates);
         combinationSumHelper(results, path, candidates, target, 0);

         return results;
     }

     private void combinationSumHelper(List<List<Integer>> result, 
            List<Integer> path, int[] candidates, int sum, int pos) {
         if (sum == 0) {
             result.add(new ArrayList<Integer>(path));
         }

         if (pos >= candidates.length || sum < 0) {
             return;
         }

         int prev = -1;
         for (int i = pos; i < candidates.length; i++) {
              if( i != 0 && candidates[i] == candidates[i-1]){
                  continue;
              }
                 path.add(candidates[i]);
                 combinationSumHelper(result, path, candidates, sum - candidates[i], i + 1);
                 prev = candidates[i];
                 path.remove(path.size()-1);
             }
         }
    */
    
}
