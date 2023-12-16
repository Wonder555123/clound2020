package com.atguigu.test2.test;

import java.util.Arrays;
public class Test2 {


    public static void main(String[] args) {

        int[] arr = new int[]{1,2,-1,23123,0,1,8,10,2891,10};
        System.out.println(binarySearch(arr,10));

    }
    public static boolean binarySearch(int[] arr,int target){

        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        while (r >= l){
            int mid = (l+r)/2;
            if(arr[mid] == target) return true;
            if(arr[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;

    }


}