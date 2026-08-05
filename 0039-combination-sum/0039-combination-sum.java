class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,n,0,target,sum,list,res);
        return res;
    }
    public void backtrack(int[] candidates,int n,int idx,int target,int sum,List<Integer> list,List<List<Integer>> res){
        if(idx==n){
            if (sum == target) {
            res.add(new ArrayList<>(list));
        }
        return;
            
        }
        backtrack(candidates,n,idx+1,target,sum,list,res);

        if (candidates[idx] != 0 && sum + candidates[idx] <= target) {
            list.add(candidates[idx]);
            backtrack(candidates, n, idx, target, sum + candidates[idx], list, res);
            list.remove(list.size() - 1);
        }
    }
}