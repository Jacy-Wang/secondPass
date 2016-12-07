# TLE
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        for i in xrange(len(s)):
            length = self.find(s, i)
            res = max(res, length)
        return res

    def find(self, s, start):
        d = {}
        i = 0
        while i + start < len(s):
            if s[start  + i] not in d.keys():
                d[s[start + i]] = 1
                i += 1
            else:
                return i

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        myDict = {}
        maxLen = 0
        i = 0
        while i < len(s):
            if s[i] not in myDict:
                myDict[s[i]] = i
                i += 1
            else:
                maxLen = max(maxLen, len(myDict))
                i = myDict[s[i]] + 1
                myDict = {}
        return max(maxLen, len(myDict))
