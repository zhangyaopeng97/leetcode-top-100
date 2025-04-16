package com.zhangyaopeng97.practice.comm;

import java.util.Objects;

public class ListNode {
	public ListNode next;
	public int val;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		if (Objects.nonNull(this.next)) {
			return this.val + " -> " + this.next;
		} else {
			return String.valueOf(this.val);
		}
	}
}

