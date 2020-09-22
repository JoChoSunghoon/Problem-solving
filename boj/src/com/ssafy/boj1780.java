package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1780 { // boj1780 종이의 개수 Silver2 하 쿼드트리 9개 버전
	private static int n;
	private static int[][] arr;
	private static int[] ans = new int[3];
	private static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0, 0 }; // 시계방향 회전
	private static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		ans = new int[3];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		search(n / 2, n / 2, n);

		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}

	public static void search(int r, int c, int n) {
		if (n == 1) { // 마지막까지 다를 때 탈출조건
			ans[arr[r][c] + 1]++;
			return;
		} else {
			if (isSame(n, r, c)) { // 같은 색종이 판단
				ans[arr[r][c] + 1]++;
			} else {
				for (int i = 0; i < 9; i++) { // 9방향 분할정복
					int x = r + dx[i] * n / 3;
					int y = c + dy[i] * n / 3;
					search(x, y, n / 3);
				}
			}
		}
	}

	private static boolean isSame(int n, int r, int c) {

		int now = arr[r][c];

		for (int i = r - n / 3; i <= r + n / 3; i++) {
			for (int j = c - n / 3; j <= c + n / 3; j++) {
				if (now != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
