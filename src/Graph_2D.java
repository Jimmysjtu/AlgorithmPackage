public class Graph_2D {

    static final double eps = 1e-10;
    static class Point {
        private double x,y;
        public Point(double x, double y) {this.x = x; this.y = y;}
    }
    static class Vector {
        private double x,y;
        public Vector(double x, double y) {this.x = x; this.y = y;}
    }
    public static int dcmp(double x) {
        if(Math.abs(x)<eps) return 0;
        else  return (x<0) ? -1 :1;
    }
    public static Vector Plus(Vector a, Vector b) {return new Vector(a.x+b.x,a.y+b.y);}
    public static Point  Plus(Point a, Vector b) {return new Point(a.x+b.x,a.y+b.y);}
    public static Vector Minus(Point a, Point b) {return new Vector(a.x-b.x,a.y-b.y);}
    public static Vector Multiply(Vector a, double p) {return new Vector(a.x*p, a.y*p);}
    public static Vector Divide(Vector a, double p) {return new Vector(a.x*p, a.y*p);}



    public static double Dot(Vector a, Vector b) {return a.x*b.x+a.y*b.y;}

    public static double Length(Vector a) {return Math.sqrt(Dot(a,a));}

    public static double Angle(Vector a, Vector b) {return Math.acos(Dot(a,b) / Length(a) / Length(b));}

    public static double Cross(Vector a, Vector b) {return a.x*b.y-a.y*b.x;}

    public static Point getLineIntersection(Point p, Vector v, Point q, Vector w) {
        Vector u = Minus(p, q);
        double t = Cross(w, u) / Cross(v, w);
        return Plus(p, Multiply(v, t));
    }

    public static double distanceToLine(Point p, Point a, Point b) {
        Vector v1 = Minus(b, a), v2  = Minus(p, a);
        return  Math.abs(Cross(v1, v2)) / Length(v1);
    }

    public static double distanceToSegment(Point p, Point a, Point b) {
        if(a.x == b.x && a.y == b.y) return Length(Minus(p,a));
        Vector v1 = Minus(b,a), v2 = Minus(p,a), v3 = Minus(p, b);
        if(dcmp(Dot(v1, v2)) < 0) return Length(v2);
        else if(dcmp(Dot(v1, v3)) > 0) return Length(v3);
        else  return Math.abs(Cross(v1, v2))/Length(v1);
    }

    public  static boolean SegmentProperIntersection(Point a1, Point a2, Point b1, Point b2) {
        double c1 = Cross(Minus(a2,a1),Minus(b1,a1)), c2 = Cross(Minus(a2,a1),Minus(b2,a1)),
                c3 = Cross(Minus(b2,b1),Minus(a1,b1)),c4 = Cross(Minus(b2,b1),Minus(a2,b1));
        return dcmp(c1)*dcmp(c2)<0 && dcmp(c3)*dcmp(c4)<0;
    }

    public static boolean onSegment(Point p, Point a1, Point a2) {
        return dcmp(Cross(Minus(a1,p), Minus(a2,p))) == 0 && dcmp(Dot(Minus(a1,p),Minus(a2,p))) <0;
    }

    public  static int isPointInPolygon(Point p, Point [] poly) {
        int wn = 0;
        int n = poly.length;

        for(int i = 0; i < n ; i++) {
            if(onSegment(p, poly[i], poly[(i+1)%n])) return -1;
            int k = dcmp(Cross(Minus(poly[(i+1)%n],poly[i]), Minus(p, poly[i])));
            int d1 = dcmp(poly[i].y-p.y);
            int d2 = dcmp(poly[(i+1)%n].y-p.y);
            if(k > 0 && d1 <=0 && d2 > 0) wn++;
            if(k < 0 && d2 <= 0 && d1 > 0) wn--;
        }
        if(wn != 0) return 1; //inner
        return 0;  //outside
    }

}
