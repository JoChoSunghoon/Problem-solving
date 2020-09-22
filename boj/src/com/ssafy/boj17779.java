package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17779 { //boj17779 게리멘더링2 gold4

	private static int n;
	private static int[][] arr;
	private static boolean[][] check;
	private static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int x = 1; x < n - 1; x++) {
			for (int y = 1; y < n - 1; y++) {
				for (int k = 0; k < n; k++) {
					Arrays.fill(check[k], false);
				}
				dfs(x, y, 1, 1);
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int x, int y, int d1, int d2) {
		if (x + d1 + d2 >= n || y - d1 < 0 || y + d2 >= n || check[d1][d2]) {
			return;
		}
		check[d1][d2] = true;

		int[] area = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j >= x + y && i - j >= x - y && i + j <= x + d2 + y + d2 && i - j <= x + d1 - y + d1) {
					area[4] += arr[i][j];
				} else if (0 <= i && i < x + d1 && 0 <= j && j <= y) {
					area[0] += arr[i][j];
				} else if (0 <= i && i <= x + d2 && y < j && j < n) {
					area[1] += arr[i][j];
				} else if (x + d1 <= i && i < n && 0 <= j && j < y - d1 + d2) {
					area[2] += arr[i][j];
				} else if (x + d2 < i && i < n && y - d1 + d2 <= j && j < n) {
					area[3] += arr[i][j];
				}
			}
		}
		Arrays.sort(area);
		ans = Math.min(ans, area[4] - area[0]);

		dfs(x, y, d1 + 1, d2);
		dfs(x, y, d1, d2 + 1);
	}
}
