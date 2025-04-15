package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // 最大堆，用于存放较小的一半元素
    private PriorityQueue<Integer> minHeap; // 最小堆，用于存放较大的一半元素
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);    // 自定义排序实现大根堆，即队列里元素从队头到队尾实现降序排列，即pop出的是里面最大的元素
        minHeap = new PriorityQueue<>();  // 默认小根堆，即队列里元素从队头到队尾实现升序排列，即pop出的是里面最小的元素
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else {
            return (double) maxHeap.peek();
        }
    }
}
