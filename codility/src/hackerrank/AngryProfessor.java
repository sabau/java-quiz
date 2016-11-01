package hackerrank;

import java.util.Scanner;

/**
 * Created by sabau on 01/11/16.
 */
public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            int ok = 0;
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                if (a[a_i] <= 0 ){
                    ok ++;
                }
            }
            if (ok < k ) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
