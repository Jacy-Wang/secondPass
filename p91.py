class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or s[0] == "0":
            return 0
        dp = [1 for _ in xrange(len(s) + 1)]
        for i in xrange(2, len(s) + 1):
            val = int(s[i - 2 : i])
            if 0 < val < 10:
                dp[i] = dp[i - 1]
            elif val == 10 or val == 20:
                dp[i] = dp[i - 2]
            elif val > 0 and val <= 26:
                dp[i] = dp[i - 1] + dp[i - 2]
            elif val % 10 == 0:
                return 0
            else:
                dp[i] = dp[i - 1]
        return dp[len(s)]
