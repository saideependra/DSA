class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
            

            int max = 0,min = Integer.MAX_VALUE;
            for(int count:freq){
                if (count > 0) {
                        max = Math.max(max, count);
                        min = Math.min(min, count);
                }
            }
            totalBeauty += (max - min);
        }
        }
        return totalBeauty;
    }

}