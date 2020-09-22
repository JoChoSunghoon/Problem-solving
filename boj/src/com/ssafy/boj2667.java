package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2667 { // boj2667 단지 번호 붙이기

	private static int[][] arr = new int[26][26];
	private static boolean[][] check = new boolean[26][26];
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int[] ans = new int[677];
	private static int n, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j] && arr[i][j] == '1') {
					dfs(i, j);
					cnt++;

				}
			}
		}

		ans = Arrays.copyOf(ans, cnt);

		Arrays.parallelSort(ans);

		System.out.println(cnt);
		for (int i : ans) {
			System.out.println(i);
		}
	}

	private static void dfs(int r, int c) {
		check[r][c] = true;

		ans[cnt]++;

		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			if (x >= 0 && x < n && y >= 0 && x < n) {
				if (!check[x][y] && arr[x][y] == '1') {
					dfs(x, y);
				}
			}
		}
	}
}
