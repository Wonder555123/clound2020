package com.atguigu.test2.test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class TestCY {

    /**
     给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     示例 1：
     输入：nums = [1,4,3,2,3]
     输出：3
     示例 2：
     输入：nums = [4,1,3,4,2]
     输出：4
     用自己认为时间复杂度和空间复杂度最优的解法。
     */
    public static void main(String[] args) {
        int [] t1 = new int[]{1,4,3,2,3};
        int [] t2 = new int[]{4,1,3,4,2};
        int helper = helper(t1);
        int helper1 = helper(t2);
        System.out.println("t1:"+helper);
        System.out.println("t2:"+helper1);
        int a = 3;
        CountDownLatch countDownLatch = new CountDownLatch(a);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(a);

    }

    public static int helper(int[] nums){
        int res = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                res = nums[i];
            }
        }
        return res;
    }

}
