package com.wsb.leetcode.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class maxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 1){
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        int num = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

class MyQueue{
    Deque<Integer> deque = new LinkedList<>();

    void poll(int val){
        if (!deque.isEmpty() && deque.peek() == val){
            deque.poll();
        }
    }

    void add(int val){
        while (!deque.isEmpty() && deque.getLast() < val){
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek(){
        return deque.peek();
    }
}
