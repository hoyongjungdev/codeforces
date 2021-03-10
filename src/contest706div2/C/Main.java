package contest706div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        var t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            var n = Integer.parseInt(br.readLine());

            var miners = new ArrayList<Long>();
            var diamonds = new ArrayList<Long>();

            for (int j=0; j<2 * n; j++) {
                var st = new StringTokenizer(br.readLine(), " ");
                var x = Long.parseLong(st.nextToken());
                var y = Long.parseLong(st.nextToken());

                if (x == 0) {
                    miners.add(Math.abs(y));
                } else {
                    diamonds.add(Math.abs(x));
                }
            }

            Collections.sort(miners);
            Collections.sort(diamonds);

            double distance = 0;

            for (int j=0; j<n; j++) {
                var m = miners.get(j);
                var d = diamonds.get(j);

                distance += Math.sqrt(m * m + d * d);
            }

            System.out.printf("%.12f\n", distance);
        }
    }
}
