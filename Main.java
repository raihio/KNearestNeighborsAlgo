import java.util.Arrays;

class Point implements Comparable<Point>{
    int val; // 0 = M, 1 = F
    double x, y;
    double distance; // distance from the new point point

    Point(int val, double x, double y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.distance > o.distance) return 1;
        else if (this.distance < o.distance) return -1;
        return 0;
    }
}

class Classifier {

    static String classifyNewPoint(Point[] arr, int n, int k, Point p) {
        for (int i = 0; i < n; i++) {
            arr[i].distance = Math.sqrt((arr[i].x - p.x) * (arr[i].x - p.x)
                    + (arr[i].y - p.y) * (arr[i].y - p.y));
        }

        Arrays.sort(arr);

        int freqOfNearMale = 0;
        int freqOfNearFemale = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i].val == 0) freqOfNearMale++;
            else if (arr[i].val == 1) freqOfNearFemale++;
        }

        return (freqOfNearMale > freqOfNearFemale ? "MALE" : "FEMALE");
    }
}

public class Main {

    public static void main(String[] args) {
        int n = 17; // Number of data points
        Point[] arr = new Point[n];

        arr[0] = new Point(0, 1, 12);
        arr[1] = new Point(0, 2,5);
        arr[2] = new Point(1, 5, 3);
        arr[3] = new Point(1, 3, 2);
        arr[4] = new Point(0, 3, 6);
        arr[5] = new Point(1, 1.5, 9);
        arr[6] = new Point(1, 7, 2);
        arr[7] = new Point(1, 6 ,1);
        arr[8] = new Point(1, 3.8, 3);
        arr[9] = new Point(0, 3 ,10);
        arr[10] = new Point(1, 5.6, 4);
        arr[11] = new Point(1, 4, 2);
        arr[12] = new Point(0, 3.5, 8);
        arr[13] = new Point(0, 2, 11);
        arr[14] = new Point(1, 2, 5);
        arr[15] = new Point(0, 2, 9);
        arr[16] = new Point(0, 1, 7);


        /*Testing Point*/
        Point testPoint = new Point(2.5, 7);

        int k = 3; // the K in KNN
        System.out.printf("unknown point is %s.\n", Classifier.classifyNewPoint(arr, n, k, testPoint));
    }
}
