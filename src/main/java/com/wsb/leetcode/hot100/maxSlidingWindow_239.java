package com.wsb.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class maxSlidingWindow_239 {

    class MyQueue{
        Deque<Integer> deque = new LinkedList<>();
        public void add(int val){
            while (!deque.isEmpty() && val > deque.getLast()){
                deque.removeLast();
            }
            deque.add(val);
        }
        public void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()){
                deque.poll();
            }
        }

        public int peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        int num = 0;
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }
}
