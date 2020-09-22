package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15649 { // boj15649 n과 m(1)
    private static int n, m;
    private static int[] arr;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        check = new boolean[n + 1];
        perm(0);
    }

    public static void perm(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            arr[cnt] = i;
            perm(cnt + 1);
            check[i] = false;
        }
    }
}
