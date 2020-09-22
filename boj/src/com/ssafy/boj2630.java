package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630 { //boj2630 색종이만들기 Silver3 하 그냥 분할정복
	private static int n;
	private static int[][] arr;
	private static int[] ans = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(n, 0, 0);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	private static void func(int n, int r, int c) {
		if (n == 1) {
			ans[arr[r][c]]++;
			return;
		}
		if (isSame(n, r, c)) {
			ans[arr[r][c]]++;
			return;
		}
		func(n / 2, r, c);
		func(n / 2, r + n / 2, c);
		func(n / 2, r, c + n / 2);
		func(n / 2, r + n / 2, c + n / 2);
	}

	private static boolean isSame(int n, int r, int c) {
		int now = arr[r][c];
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (now != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
