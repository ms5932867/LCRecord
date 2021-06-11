// condition check to avoid duplicate ref: LC 47
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        dfs(candidates, 0, new ArrayList<>(), target);
        return res;
    }
    private void dfs(int[] candidates, int index, List<Integer> curRes, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
      
        dfs(candidates, index + 1, curRes, target ) ;

        if (index > 0 && candidates[index] == candidates[index - 1] && !used[index - 1]) {
            return;
        }

        used[index] = true;
        curRes.add(candidates[index]);
        dfs(candidates, index + 1, curRes, target - candidates[index]);
        curRes.remove(curRes.size() - 1);
        used[index] = false;

        
        
        
    }
    
}