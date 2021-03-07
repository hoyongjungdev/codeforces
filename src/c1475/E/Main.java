package c1475.E;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    long[][] cache = new long[1001][1001];
    long MOD = 1000000007;

    public static void main(String[] args) {
        var main = new Main();
        main.reset();

        var sc = new Scanner(System.in);
        var t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            var arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            System.out.println(main.count(n, k, arr));
        }
    }

    public long count(int n, int k, int[] arr) {
        long possible = -1;

        var map = new TreeMap<Integer, Integer>(Collections.reverseOrder());

        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int left = k;

        for (int key : map.keySet()) {
            var value = map.get(key);

            if (left > value) {
                left -= value;
            } else {
                possible = c(value, left);
                break;
            }
        }

        return possible;
    }

    public void reset() {
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                cache[i][j] = -1;
            }
        }
    }

    public long c(int n, int k) {
        if (n < k || n < 0 || k < 0) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        if (k == 1) {
            return n;
        }

        if (cache[n][k] != -1) {
            return cache[n][k];
        }

        var result = (c(n - 1, k - 1) + c(n - 1, k)) % MOD;
        cache[n][k] = result;

        return result;
    }
}
