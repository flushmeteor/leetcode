import java.util.LinkedList;


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class Solution {
	
	public ListNode swapPairs(ListNode head) {
        LinkedList<ListNode> list = new LinkedList();
        int count = 0;
        if(head==null||head.next==null){
        	return head;
        }
        //交换之后的链表特点是：原来偶数位上的指针指向其前面的节点，原来奇数位k上的节点指向第（k+3)个节点
        while(head!=null){
        	list.add(head);
        	head = head.next;
        	count++;
        	if(count%2==0){
        		list.get(count-1).next = list.get(count-2);
        		if(count>3){
        			list.get(count-4).next = list.get(count-1);
        		}
        	}
        }
        //交换完后的链表尾部节点需要处理，如果总数为偶数，需将倒数第二个节点的指针置为空；
        //如果总数为奇数，需将倒数第三个节点的指针指向最后一个节点，并将最后一个节点的指针置为空
        if(count%2==0){
        	list.get(count-2).next = null;
        }else{
        	list.get(count-3).next = list.get(count-1);
        	list.get(count-1).next = null;
        }
        //因为做了交换，原来的第二个节点成了头节点
        return list.get(1);
    }
}
