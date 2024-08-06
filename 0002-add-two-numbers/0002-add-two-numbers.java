/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 두 개의 비어있지 않은 링크드 리스트, 숫자는 0~9 (숫자 앞에 0 없음. 0 아니면)
        int addNext = 0;
        Queue<Integer> numQueue = new ArrayDeque();
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;

            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int newVal = a + b + addNext;            
            addNext = newVal / 10;
            newVal = newVal % 10;
            numQueue.add(newVal);
        }
        if (addNext != 0)
            {numQueue.add(addNext);}

        int start = numQueue.poll();
        ListNode newNode = new ListNode(start);
        ListNode node = newNode;
        while (!numQueue.isEmpty()) {
            int num = numQueue.poll();
            ListNode tempNode = new ListNode(num);
            node.next = tempNode;
            node = node.next;
        }

        return newNode;
    }
}