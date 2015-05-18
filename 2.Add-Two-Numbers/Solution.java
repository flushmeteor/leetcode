public class Solution {
    public class ListNode {
        int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ls = new ListNode(0);
        ListNode lt = new ListNode(0);
        ListNode lt1;
        int a = 0;
        int val = 0;
        
        //第一个node的计算
        val = l1.val + l2.val;
        a = val/10;//进位
        ls.val = val%10;
        lt = ls;
        
        while(l1.next!=null&&l2.next!=null){
        	l1 = l1.next;
        	l2 = l2.next;
        	val = l1.val + l2.val+a;
            a = val/10;
            lt1 =new ListNode(val%10);
            lt.next = lt1;
            lt = lt1;
        }
        
        while(l1.next!=null){
        	val = l1.next.val + a;
        	a = val/10;
        	lt1 =new ListNode(val%10);
        	lt.next = lt1;
        	if(a==0){
        		lt1.next = l1.next.next;
        		break;
        	}
        		
        	l1 = l1.next;
        	lt = lt1;
        	
        }
        
        while(l2.next!=null){
        	val = l2.next.val + a;
        	a = val/10;
        	lt1 =new ListNode(val%10);
        	lt.next = lt1;
        	if(a==0){
        		lt1.next = l2.next.next;
        		break;
        	}
        		
        	l2 = l2.next;
        	lt = lt1;
        }
        
        if(a==1){
        	lt.next = new ListNode(1);
        }
        return ls;
    }
}
