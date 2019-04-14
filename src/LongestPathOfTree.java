import java.util.Arrays;
import java.util.Scanner;

public class LongestPathOfTree {


    public static int N;
    public static int Tree [][];
    public static int vis[];
    public static int dis1[];
    public static int dis2[];


    public static int dfs(int i) {
        vis[i] = 1;
        System.out.println(Arrays.toString(vis));
        for(int j = 1;j<=N;j++) {

            if(Tree[i][j] != 0 && vis[j] == 0) {
                int tem = dfs(j);
                if(tem+Tree[i][j]>dis1[i]) {
                    dis2[i] = dis1[i];
                    dis1[i] = Tree[i][j] + tem;

                }
                else if(tem+Tree[i][j]>dis2[i]) {
                    dis2[i] = tem+Tree[i][j];
                }
            }
        }
        return dis1[i];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        Tree = new int [N+1][N+1];
        vis = new int[N+1];
        dis1 = new int[N+1];
        dis2 = new int[N+1];
        for(int i = 1;i<N;i++) {
            int a;
            int b;
            int c;
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            Tree[a][b] = c;
            Tree[b][a] = c;
        }
        dfs(1);
        System.out.println(Arrays.toString(dis1));
        System.out.println(Arrays.toString(dis2));

    }



}
