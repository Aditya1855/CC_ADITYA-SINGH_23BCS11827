import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        while (m-- > 0) {
            String s = sc.next();
            boolean found = false;

            char[] arr = s.toCharArray();

            for (int i = 0; i < arr.length && !found; i++) {
                char original = arr[i];

                for (char ch : new char[]{'a', 'b', 'c'}) {
                    if (ch == original) continue;

                    arr[i] = ch;
                    String modified = new String(arr);

                    if (set.contains(modified)) {
                        found = true;
                        break;
                    }
                }

                arr[i] = original;
            }

            if (found) System.out.println("YES");
            else System.out.println("NO");
        }

        sc.close();
    }
}