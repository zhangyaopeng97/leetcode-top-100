package com.zhangyaopeng97.practice.top1_10;

import com.zhangyaopeng97.practice.comm.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author zyp
 * @see <a href="题目地址">https://leetcode.cn/problems/reverse-linked-list</a>
 * @since 2025/04/15 17:32
 */
public class practice3 {
	public static ListNode reverseList(ListNode head) {
		//head->1 -> 2 -> 3 -> 4 -> 5
		if (head == null || head.next == null) {
			return head;
		}
		//                  HEAD->1
		//                        ↓
		//newHead->5 -> 4 -> 3 -> 2
		ListNode newHead = reverseList(head.next);


		//                 HEAD-> 1
		//                        ↑↓
		//newHead->5 -> 4 -> 3 -> 2
		head.next.next = head;


		//                 HEAD->1
		//                        ↑
		//newHead->5 -> 4 -> 3 -> 2
		head.next = null;


		//newHead->5 -> 4 -> 3 -> 2 ->1
		return newHead;
	}

	public static void main(String[] args) {
		ListNode listNodes = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		System.out.println(listNodes);
		System.out.println(reverseList(listNodes));
	}
}


