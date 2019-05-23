public class ReverseLinkedList {
    public static void reverse(root) {
        // 反转链表
        if(root == null || root.next == null)
            return root;
        ListNode p = null;
        ListNode q = root;
        ListNode r = root.next;
        while(q.next != null) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        q.next = p;
        return q;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}