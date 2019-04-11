package com.company;

public class BinarySearch {
    public static boolean check(int k) {
        return k<5;
    }
    public static int search() {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int ans = 0;
        int mid = 0;
        while (left<=right) {
            mid = (left+right)>>1;
            if(check(mid)) {
                ans = mid;
                left = mid+1;
            }
            else right = mid-1;
        }
        return ans;
    }
}
