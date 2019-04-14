package com.company;

import java.io.IOException;
import java.util.*;


public class Main {
    public static long [] h;
    public static long n;

    public static boolean check(long k) {
        long e = k;
        for(int i = 0;i<n;i++) {
            e = e + (e-h[i]);
            if (e<0) return false;
        }
        return true;
    }
    public static long search() {
        long left = 0;
        long right = 10000000;
        long ans = 0;
        long mid = 0;
        while (left<=right) {
            mid = (left+right)>>1;
            if(check(mid)) {
                ans = mid;
                right = mid-1;
            }
            else left = mid+1;
            //System.out.println(mid);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        h = new long [(int)n];
        for(int i = 0;i<n;i++) {
            h[i] = scanner.nextInt();
        }
        //System.out.println(Arrays.toString(h));

        System.out.println(search());

    }

}
