class Solution {
    public long subArrayRanges(int[] nums) {
        return sumOfMax(nums) - sumOfMin(nums);
    }
    private long sumOfMin(int[] nums){
        int n = nums.length;
        int[] left = new int[n],right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()? i+1 : i-stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (long) nums[i] * left[i] * right[i];
        }
        return total;
    }

    private long sumOfMax(int[] nums){
        int n = nums.length;
        int[] left = new int[n],right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()? i+1 : i-stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (long) nums[i] * left[i] * right[i];
        }
        return total;
    }
}