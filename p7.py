class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        negSign = (x < 0)
        num = abs(x)
        reversedNumInStr = self.reverseStr(str(num)).lstrip("0")
        if not reversedNumInStr:
            return 0
        MAX_INT = 2147483647
        cand = int(reversedNumInStr)
        if cand > MAX_INT:
            if not negSign:
                return 0
            else:
                if cand == MAX_INT + 1:
                    return -cand
                else:
                    return 0
        return cand if not negSign else -cand
        
    def reverseStr(self, s):
        t = ""
        for i in xrange(len(s) - 1, -1, -1):
            t += s[i]
        return t
