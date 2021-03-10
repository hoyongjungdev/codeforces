package contest706div2.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var main = new Main();
        var sc = new Scanner(System.in);

        int t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            var n = sc.nextInt();
            var k = sc.nextInt();
            sc.nextLine();

            var str = sc.nextLine();

            var result = main.sub(n, k, str);

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    public boolean sub(int n, int k, String str) {
        if (n < 2 * k + 1) {
            return false;
        }

        for (int i = 0; i < k; i++) {
            var a = str.charAt(i);
            var b = str.charAt(n - 1 - i);

            if (a != b) {
                return false;
            }
        }
        return true;
    }
}
