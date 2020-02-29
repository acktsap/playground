import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Descryption
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.=
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   Output: 7 -> 0 -> 8
 *   Explanation: 342 + 465 = 807.
 *
 * Approach
 *
 * Loop Invarient
 *
 *  - pre holds pre pointer
 *  - left holds l1 pointer or null
 *  - left holds l2 pointer or null
 *  - overflow == 1 if pre has overflow
 *
 * Space : O(n)
 * Time  : O(n)
 * 
 * Review
 *
 *  - Use dummy head list for pre (and return dummy.next)
 *
 */
class AddTwoNumbers {

  public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
    final ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    ListNode left = l1;
    ListNode right = l2;
    int overflow = 0;
    while (null != left && null != right) {
      final int val = left.val + right.val + overflow;
      pre.next = new ListNode(val % 10);
      overflow = val / 10;
      pre = pre.next;
      left = left.next;
      right = right.next;
    }
    while (null != left) {
      final int val = left.val + overflow;
      pre.next = new ListNode(val % 10);
      overflow = val / 10;
      pre = pre.next;
      left = left.next;
    }
    while (null != right) {
      final int val = right.val + overflow;
      pre.next = new ListNode(val % 10);
      overflow = val / 10;
      pre = pre.next;
      right = right.next;
    }
    if (1 == overflow) {
      pre.next = new ListNode(1);
      pre = pre.next;
    }
    return dummy.next;
  }

  public static void main(final String[] args) {
    final Object[][] parameters = new Object[][] {
      {
        new int[] { 2, 4, 3 },
        new int[] { 5, 6, 4 },
        new int[] { 7, 0, 8 },
      },
      {
        new int[] { 2, 4, 5 },
        new int[] { 5, 6, 4 },
        new int[] { 7, 0, 0, 1 },
      },
      {
        new int[] { },
        new int[] { 5, 6, 4 },
        new int[] { 5, 6, 4 },
      },
    };
    final AddTwoNumbers solution = new AddTwoNumbers();
    for (final Object[] parameter : parameters) {
      final int[] l1 = (int[]) parameter[0];
      final int[] l2 = (int[]) parameter[1];
      final int[] expected = (int[]) parameter[2];
      final int[] actual = solution.addTwoNumbers(ListNode.of(l1), ListNode.of(l2)).toArray();
      if (!Arrays.equals(expected, actual)) {
        throw new IllegalStateException("Expected: " + Arrays.toString(expected) +
            ", actual: " + Arrays.toString(actual));
      }
    }
  }
}
