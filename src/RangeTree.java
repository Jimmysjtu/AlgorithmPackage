public class RangeTree {

    public static int N = 100;
    public static int ori[] = new int [N];
    public static int mi[] = new int [4*N];

    public static void build(int k, int l, int r)
    {
        if(l == r) {
            mi[k] = ori[l];
            return ;
        }
        int mid  = (l+r)/2;
        build(k*2, l, mid);
        build (k*2+1, mid+1,r);
        mi[k] = Math.min(mi[k*2], mi[2*k+1]);

    }
    public static void change(int k, int l, int r, int x, int v)
    {
        if(r<x||l>x) return;
        if(l==r&&l == x) {
            mi[k] = v;
            return;
        }
        int mid = (l+r)/2;
        change(k*2, l, mid, x, v);
        change(k*2+1, mid+1, r, x, v);
        mi[k] = Math.min(mi[k*2], mi[k*2+1]);

    }
    public static int query_min(int k, int x, int y, int l, int r) {
        if(r<x||l>y) return Integer.MAX_VALUE;
        if(l>=x&&r<=y) return mi[k];
        int mid = (l+r)/2;

        return Math.min(query_min(k*2, x, y, l, mid), query_min(k*2+1, x, y, mid+1, r));
    }

}
