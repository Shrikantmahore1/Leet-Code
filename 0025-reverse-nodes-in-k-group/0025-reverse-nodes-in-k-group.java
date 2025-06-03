/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode thead = new ListNode(0);
        ListNode prevend = thead, curr = head;
        int n = length(head);
        for(int i = 1; i <= n / k; i++){
            ListNode prev = null, grpstart = curr;
            int len = k;
            while(len > 0 && curr != null){
                len--;
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            prevend.next = prev;
            grpstart.next = curr;
            prevend = grpstart;
        }
        return thead.next;
    }
    private int length(ListNode head){
        int i = 0;
        while(head != null){
            i++;
            head = head.next;
        }
        return i;
    }
}