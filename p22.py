class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        self.res = []
        self.generate(n, 0, 0, "")
        return self.res
        
    def generate(self, n, l, r, s):
        if l == r and l == n:
            self.res.append(s)
        if l < n:
            self.generate(n, l + 1, r, s + "(")
        if r < l:
            self.generate(n, l, r + 1, s + ")")
