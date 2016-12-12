# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        node = dummy
        while node.next and node.next.next:
            nextNode = node.next
            node.next = nextNode.next
            nextNode.next = node.next.next
            node.next.next = nextNode
            node = nextNode
        return dummy.next
