class Solution:
    def maxProduct(self, nums: list[int]) -> int:
        cur_max = cur_min = result = nums[0]

        for num in nums[1:]:
            choices = (num, cur_max * num, cur_min * num)
            cur_max = max(choices)
            cur_min = min(choices)
            result = max(result, cur_max)

        return result
        