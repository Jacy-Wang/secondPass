class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.nums = sorted(nums)
        self.res = []
        self.get([], 0)
        return self.res

    def get(self, cur, start):
        self.res.append(cur[:])
        for i in xrange(start, len(self.nums)):
            if i > start and self.nums[i - 1] == self.nums[i]:
                continue
            cur.append(self.nums[i])
            self.get(cur, i + 1)
            cur.pop()
