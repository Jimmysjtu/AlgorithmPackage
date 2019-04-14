package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class TreeHeart {

    public static int N;
    public static int Tree [][];
    public static int NumOfChildern[];
    public static int res = Integer.MAX_VALUE;
    public static int vis[];

    public static int dfs(int i) {
        System.out.println(i);
        int sum = 0;
        int MaxNode = 0;
        int node = 0;
        vis[i] = 1;
        for(int j = 1;j<=N;j++) {
            if(Tree[i][j] ==1 && vis[j] == 0) {
                node = dfs(j);
                MaxNode = Math.max(node,MaxNode);
                sum += node;
            }
        }
        NumOfChildern[i] = sum+1;
        res = Math.min(res,Math.max(N-NumOfChildern[i],MaxNode));
        return NumOfChildern[i];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        Tree = new int [N+1][N+1];
        vis = new int[N+1];
        NumOfChildern = new int[N+1];
        for(int i = 1;i<N;i++) {
            int a;
            int b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            Tree[a][b] = 1;
            Tree[b][a] = 1;
        }
        dfs(1);
        System.out.println(res);
        System.out.println(Arrays.toString(NumOfChildern));
    }
}
