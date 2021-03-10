package contest706div2.D;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static class Element {
        boolean upper;
        int length;

        Element(boolean upper, int length) {
            this.upper = upper;
            this.length = length;
        }

        @Override
        public String toString() {
            var str = "";

            if (upper) {
                str += "U";
            } else {
                str += "D";
            }

            return str + length;
        }
    }

    public static void main(String[] args) {
        var main = new Main();
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        var line = new StringTokenizer(sc.nextLine(), " ");

        var arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line.nextToken());
        }

        System.out.println(main.solve(arr));


    }

    public int solve(int[] arr) {
        var zipped = zip(arr);
//        for (var z : zipped) {
//            System.out.printf("%s ", z);
//        }

        var l = largest(zipped);
        var m = l[0];
        var s = l[1];

        var result = 0;

        for (int i = 0; i < zipped.size() - 1; i++) {
            var left = zipped.get(i);
            var right = zipped.get(i + 1);

            if (!left.upper) {
                continue;
            }

            if (left.length < m && right.length < m) {
                continue;
            }

            int here = 0;
            if (left.length == m) {
                here++;
            }

            if (right.length == m) {
                here++;
            }

            if (here < s) {
                continue;
            }

            var ol = opponent(left.length);
            var or = opponent(right.length);

            if (ol >= right.length || or >= left.length) {
                continue;
            }

            result += 1;
        }

        return result;
    }

    public ArrayList<Element> zip(int[] arr) {
        boolean upper = true;
        var length = 1;

        var zip = new ArrayList<Element>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (upper) {
                if (arr[i] < arr[i + 1]) {
                    length++;
                } else {
                    if (length >= 2) {
                        zip.add(new Element(true, length));
                    }
                    length = 2;
                    upper = false;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    length++;
                } else {
                    if (length >= 2) {
                        zip.add(new Element(false, length));
                    }

                    length = 2;
                    upper = true;
                }
            }
        }

        zip.add(new Element(upper, length));

        return zip;
    }

    public int[] largest(ArrayList<Element> arr) {
        var result = new int[2];

        int m = -1;
        int size = 0;

        for (var e : arr) {
            if (m < e.length) {
                m = e.length;
                size = 1;
            } else if (m == e.length) {
                size++;
            }
        }

        result[0] = m;
        result[1] = size;

        return result;
    }

    public int opponent(int length) {
        return length - (length % 2);
    }
}
