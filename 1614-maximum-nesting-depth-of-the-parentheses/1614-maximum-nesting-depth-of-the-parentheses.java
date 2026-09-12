class Solution {
    public int maxDepth(String s) {
        int depth = 0, maxdepth=0;
        for(int c :s.toCharArray()){
            if(c == '('){
                depth++;
                maxdepth = Math.max(depth,maxdepth);
            }else if(c == ')'){
                depth--;
            }
        }       
        return maxdepth;
    }
}