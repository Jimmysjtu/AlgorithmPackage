import java.util.Scanner;

public class Range_DP {

    public static int dp[][];
    public static int arr[];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        dp = new int [N+5][N+5];
        arr = new int [N+2];
        arr[0] = 1;
        for(int i = 1;i<=N;i++)
            arr[i] = scan.nextInt();
        arr[N+1] = 1;
        for(int i = 0;i<N+2;i++)
            dp[i][i+1] = 0;
        for(int len = 2;len<N+2;len++)
        {
            for(int i = 0,j;(j = i+len)<N+2;i++)
            {
                dp[i][j] = Integer.MIN_VALUE;
                for(int k = i+1;k<j;k++) {
                    dp[i][j] = Math.max(dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j],dp[i][j]);
                }
            }
        }
        System.out.println(dp[0][N+1]);

    }


}
