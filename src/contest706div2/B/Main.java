package contest706div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var main = new Main();
        var br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        var t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            var line = new StringTokenizer(br.readLine(), " ");
            var n = Integer.parseInt(line.nextToken());
            var k = Integer.parseInt(line.nextToken());

            line = new StringTokenizer(br.readLine(), " ");
            var arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(line.nextToken());
            }

            System.out.println(main.set(n, k, arr));
        }
    }

    public int set(int n, int k, int[] arr) {
        if (k == 0) {
            return n;
        }

        Arrays.sort(arr);

        int mex = -1;

        if (arr[0] > 0) {
            mex = 0;
        } else {
            for (int i=0; i<n-1; i++) {
                if (arr[i+1] - arr[i] > 1) {
                    mex = arr[i] + 1;
                    break;
                }
            }
        }

        if (mex == -1) {
            return arr.length + k;
        } else {
            var mid = (arr[n-1] + mex + 1) / 2;

            for (int i=0; i<n; i++) {
                if (arr[i] == mid) {
                    return n;
                }
            }

            return n + 1;
        }
    }
}
