import java.util.Arrays;

public class StateSpaceCompressionDP {

    public static int N;
    public static int K;
    public static int state[];
    public static int num[];
    public static int ptr;
    public static int DP[][][];

    public static void prepare() {
        ptr = 0;
        state = new int[155];
        num = new int[155];
        for(int i = 0;i<(1<<N);i++) {

            int cnt = 0;
            if((i & i<<1) == 0) {
                for(int j = 0;j<N;j++) if((i&1<<j)!=0) cnt++;
                state[++ptr] = i;
                num[ptr] = cnt;
            }
        }
    }
    public static int dp() {
        DP = new int [11][155][155];

        int ans = 0;
        DP[0][1][0] = 1;
        for (int i = 1; i <= N; i++)
            for (int statecur = 1; statecur <= ptr; statecur++)
                for (int cntpre = 0; cntpre <= K; cntpre++)
                    if (cntpre>=num[statecur])
                        for (int statepre = 1;statepre<=ptr;statepre++)
                            if ((state[statepre]&state[statecur])==0 && (state[statepre]&state[statecur]<<1)==0 && (state[statepre]&state[statecur]>>1)==0)
                                DP[i][statecur][cntpre] += DP[i-1][statepre][cntpre-num[statecur]];

                            for (int i = 1;i<=ptr;i++) ans += DP[N][i][K];

                            return ans;

    }

    public static void main(String[] args) {
        N = 10;
        K = 5;

        prepare();
        dp();


        System.out.println(dp());


    }
}
