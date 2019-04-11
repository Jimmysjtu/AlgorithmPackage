package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static int N = 3;
    public static int M = 3;
    public static int[][] graph = {{0,0,0}, {1,1,0}, {9,0,0}};
    public static int bfs(int x, int y) {
        final int [] dct_x = {0,1,0,-1};
        final int [] dct_y = {1,0,-1,0};
        int [][] vis = new int [N][M];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int []{x,y,0});
        while (!queue.isEmpty()) {
            int [] tem = queue.poll();
            //找到了结果
            if(graph[tem[0]][tem[1]]==9) return tem[2];

            if(vis[tem[0]][tem[1]] == 1) continue;
            else vis[tem[0]][tem[1]] = 1;
            System.out.println(Arrays.toString(tem));
            for(int i = 0; i < 4; i++)
            {
                int new_x = tem[0]+dct_x[i];
                int new_y = tem[1]+dct_y[i];
                int level = tem[2]+1;


                if(new_x >=0 && new_x <M && new_y >=0 && new_y<N && vis[new_x][new_y] == 0 && graph[new_x][new_y] != 1) {
                    queue.add(new int[]{new_x,new_y,level});
                }

            }

        }
        return -1;
    }
}
