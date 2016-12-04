class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        res = ""
        i = 0
        base = 2 * numRows - 2
        for i in xrange(numRows):
            pos = i
            if i == 0 or i == numRows - 1:
                while pos < len(s):
                    res += s[pos]
                    pos += base
            else:
                while pos < len(s):
                    res += s[pos]
                    if pos + 2 * (numRows - i - 1) < len(s):
                        res += s[pos + 2 * (numRows - i - 1)]
                    pos += base
        return res
