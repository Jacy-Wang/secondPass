def my3Sum(nums):
    sortedNums = sorted(nums)
    cand = set()
    for i in xrange(len(nums)):
        v = sortedNums.pop(i)
        left = 0
        right = len(sortedNums) - 1
        while left < right:
            tmp = sortedNums[left] + sortedNums[right]
            if tmp == -v:
                cand.add(tuple(sorted((v, sortedNums[left], sortedNums[right]))))
                left += 1
                right -= 1
            elif tmp < -v:
                left += 1
            else:
                right -= 1
        sortedNums.insert(i, v)
    res = []
    for triple in cand:
        res.append(list(triple))
    return res

if __name__ == "__main__":
    nums = [-1,0,1,2,-1,-4]
    print my3Sum(nums)
