package com.leetcode.code;

import java.awt.image.VolatileImage;

/**
 * Created by root on 16-10-9.
 */
public class AddTwoNumbers {
    public static void main(String[] args){

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 =null;
        while(l1.next!=null && l2.next!=null){
            if (l3==null) {
                l3 = new ListNode(l1.val + l2.val);
            }else{
                l3.next = new ListNode(l1.val + l2.val);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l3;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

