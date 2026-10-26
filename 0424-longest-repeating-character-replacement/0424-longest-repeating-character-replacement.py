class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {}
        left = 0
        maxcnt = 0
        best = 0

        for right,ch in enumerate(s):
            count[ch] = count.get(ch,0)+1
            maxcnt = max(maxcnt, count[ch])

            if (right-left+1) - maxcnt > k:
                count[s[left]] -= 1
                left += 1
            best = max(best, right - left + 1)
        return best