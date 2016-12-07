class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        base = 10
        while x / base > 0:
            base *= 10
        base /= 10
        while x > 0:
            l = x / base
            r = x % 10
            if l == r:
                x = (x % base) / 10
                base /= 100
            else:
                return False
        return True
