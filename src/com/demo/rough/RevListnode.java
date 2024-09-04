package com.demo.rough;

public class RevListnode {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode
				(5, new ListNode
						(8, new ListNode
								(10, new ListNode(20))));
		System.out.println(l1);
		
		ListNode l2 = revListNodeOrder(l1);
		System.out.println(l2);

	}

	private static ListNode revListNodeOrder(ListNode l1) {
		
		ListNode prev = null;
		ListNode next = null;
		ListNode curr = l1;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}

class ListNode{
	int val;
	ListNode next;
	public ListNode() {
		
	}
	public ListNode(int val) {
		this.val = val;
	}
	public ListNode(int val, ListNode l) {
		this.val = val;
		this.next = l;
	}
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
}