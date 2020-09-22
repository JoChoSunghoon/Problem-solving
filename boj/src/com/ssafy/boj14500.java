package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 { // boj14500 테트로미노, 하, dfs사용후 ㅏ 모양 테트리스만 한번 더 확인

	private static int[][] arr;
	private static boolean[][] check;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n, m, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		check = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j, 0, 0);
				check[i][j] = false;
				checkShape(i,j);
			}
		}

		System.out.println(ans);
	}

	public static void dfs(int r, int c, int cnt, int sum) {
		if (cnt == 4) {
			if (sum > ans) {
				ans = sum;
			}
			return;
		}
		check[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			if (x >= 0 && x < n && y >= 0 && y < m && !check[x][y]) {
				dfs(x, y, cnt + 1, sum + arr[x][y]);
				check[x][y] = false;
			}
		}
	}

	public static void checkShape(int r, int c) {
		int sum = 0;
		if (r + 2 < n && c + 1 < m) {
			sum = arr[r][c] + arr[r + 1][c] + arr[r + 1][c + 1] + arr[r + 2][c];
			if (sum > ans) {
				ans = sum;
			}
		}
		if (r + 2 < n && c - 1 >= 0) {
			sum = arr[r][c] + arr[r + 1][c] + arr[r + 1][c - 1] + arr[r + 2][c];
			if (sum > ans) {
				ans = sum;
			}
		}
		if (r - 2 >= 0 && c + 1 < m) {
			sum = arr[r][c] + arr[r - 1][c] + arr[r - 1][c + 1] + arr[r - 2][c];
			if (sum > ans) {
				ans = sum;
			}
		}
		if (r - 2 >= 0 && c - 1 >= 0) {
			sum = arr[r][c] + arr[r - 1][c] + arr[r - 1][c - 1] + arr[r - 2][c];
			if (sum > ans) {
				ans = sum;
			}
		}
		if (r + 1 < n && c + 2 < m) {
			sum = arr[r][c] + arr[r][c + 1] + arr[r + 1][c + 1] + arr[r][c + 2];
			if (sum > ans) {
				ans = sum;
			}
		}
		if (r - 1 >= 0 && c + 2 < m) {
			sum = arr[r][c] + arr[r][c + 1] + arr[r - 1][c + 1] + arr[r][c + 2];
			if (sum > ans) {
				ans = sum;
			}
		}
		if (r + 1 < n && c - 2 >= 0) {
			sum = arr[r][c] + arr[r][c - 1] + arr[r + 1][c - 1] + arr[r][c - 2];
			if (sum > ans) {
				ans = sum;
			}
		}
		if (r - 1 >= 0 && c - 2 >= 0) {
			sum = arr[r][c] + arr[r][c - 1] + arr[r - 1][c - 1] + arr[r][c - 2];
			if (sum > ans) {
				ans = sum;
			}
		}

	}
}
