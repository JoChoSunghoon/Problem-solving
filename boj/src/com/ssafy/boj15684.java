package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15684 { // boj15684 사다리조작 Gold5 중상
	private static int n, m, h;
	private static boolean[][] ladder;
	private static int ans = 4;
	private static boolean complete;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 가로
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken()); // 세로

		ladder = new boolean[h + 1][n + 1];

		int a, b;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}
		
		dfs(1,0);
		if(ans == 4) {
			ans = -1;
		}
		System.out.println(ans);
	}

	public static void dfs(int col, int cnt) {
		if (cnt >= ans || col == n ) {
			return;
		}

		if (check()) {
			if (cnt < ans) {
				ans = cnt;
			}
			return;
		}

		for (int i = 1; i <= h; i++) {
			if (!ladder[i][col - 1] && !ladder[i][col] && !ladder[i][col + 1]) {
				ladder[i][col] = true;
				dfs(col, cnt + 1);
				ladder[i][col] = false;
			}
		}

		dfs(col + 1, cnt);

	}

	public static boolean check() {
		for (int col = 1; col < n; col++) {
			int r = 1;
			int c = col;

			while (r != h + 1) {
				if (ladder[r][c - 1]) {
					c--;
				} else if (ladder[r][c]) {
					c++;
				}
				r++;
			}
			if (c != col) {
				return false;
			}
		}
		return true;
	}
}
