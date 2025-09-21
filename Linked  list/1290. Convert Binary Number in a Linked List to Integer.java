/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

The most significant bit is at the head of the linked list.

 

Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
 

Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
*/

//SOURCE CODE:
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder s = new StringBuilder(); // initialize

        ListNode temp = head;
        while (temp != null) {
            s.append(temp.val); // add current bit
            temp = temp.next;   // move forward
        }

        // Convert binary string to integer
        return Integer.parseInt(s.toString(), 2);
    }
}
