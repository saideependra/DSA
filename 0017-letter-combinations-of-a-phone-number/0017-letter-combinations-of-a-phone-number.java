class Solution {
    private static final String[] KEYPAD = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        backtrack(result,new StringBuilder(),digits,0);
        return result;
    }
    public void backtrack(List<String> res,StringBuilder curr,String digits,int idx){
        if(curr.length() == digits.length()){
            res.add(curr.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        String letters = KEYPAD[digit];
        for(int i = 0; i<letters.length() ; i++){
            curr.append(letters.charAt(i));
            backtrack(res,curr,digits,idx+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}