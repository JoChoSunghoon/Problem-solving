package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14499 { // boj14499 주사위 굴리기

	private static int n, m, x, y, k;
	private static int[][] arr;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int[] dice = new int[6];
	private static int[][] dir = { { 2, 5, 3, 0 }, { 3, 5, 2, 0 }, { 1, 5, 4, 0 }, { 4, 5, 1, 0 } };
	private static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < k; i++) {
			c = Integer.parseInt(st.nextToken()) - 1;

			int nx = x + dx[c];
			int ny = y + dy[c];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				int temp = dice[dir[c][0]];
				for (int j = 0; j < 3; j++) {
					dice[dir[c][j]] = dice[dir[c][j + 1]];
				}
				dice[dir[c][3]] = temp;

				if (arr[nx][ny] == 0) {
					arr[nx][ny] = dice[5];
				} else {
					dice[5] = arr[nx][ny];
					arr[nx][ny] = 0;
				}
				System.out.println(dice[0]);
				x = nx;
				y = ny;
			}
		}
	}

}
