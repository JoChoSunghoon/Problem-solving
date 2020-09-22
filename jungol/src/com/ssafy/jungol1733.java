package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol1733 { // jungol1733 오목
	private static int[][] arr = new int[19][19];
	private static int[] dx = { 1, 1, 0, -1 };
	private static int[] dy = { 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int rx = 0;
		int ry = 0;
		int ans = 0;

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				for (int d = 0; d < 4; d++) {
					if (arr[i][j] != 0) {
						if (check(i - dx[d], j - dy[d]) == arr[i][j]) {
							continue;
						}
						int x = i;
						int y = j;
						int cnt = 0;

						while (true) {
							x += dx[d];
							y += dy[d];
							if (check(x, y) != arr[i][j]) {
								break;
							}
							cnt++;
						}

						if (cnt == 4) {
							rx = i + 1;
							ry = j + 1;
							ans = arr[i][j];
						}

					}
				}
			}
		}

		System.out.println(ans);
		if (ans != 0) {
			System.out.println(rx + " " + ry);
		}

	}

	public static int check(int y, int x) {
		if (x < 0 || x >= 19 || y < 0 || y >= 19) {
			return 0;
		}
		return arr[y][x];
	}

}
