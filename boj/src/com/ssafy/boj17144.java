package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());

		int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
		int[] dy = { 0, 0, -1, 1 };

		int[][] arr = new int[r][c];
		int[][] arr2 = new int[r][c];

		int up = 0;
		int down = 0;

		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1 && up == 0) {
					up = i;
					down = up + 1;
				}
			}
		}

		for (int t = 0; t < time; t++) {
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] != 0) {
						int dust = arr[i][j];
						arr2[i][j] += dust;
						for (int k = 0; k < 4; k++) {
							int x = i + dx[k];
							int y = j + dy[k];
							if (x >= 0 && x < r && y >= 0 && y < c && arr[x][y] != -1) {
								arr2[x][y] += dust / 5;
								arr2[i][j] -= dust / 5;
							}
						}
					}
				}
			}
			// 회전 추가

			for (int i = up - 1; i > 0; i--) {
				arr2[i][0] = arr2[i - 1][0];
			}
			for (int j = 0; j < arr[0].length - 1; j++) {
				arr2[0][j] = arr2[0][j + 1];
			}
			for (int i = 0; i < up; i++) {
				arr2[i][arr[0].length - 1] = arr2[i + 1][arr[0].length - 1];
			}
			for (int j = arr[0].length - 1; j > 0; j--) {
				arr2[up][j] = arr2[up][j - 1];
			}
			arr2[up][1] = 0;

			for (int i = down + 1; i < r - 1; i++) {
				arr2[i][0] = arr2[i + 1][0];
			}
			for (int j = 0; j < arr[0].length - 1; j++) {
				arr2[r - 1][j] = arr2[r - 1][j + 1];
			}
			for (int i = arr.length - 1; i > down; i--) {
				arr2[i][c - 1] = arr2[i - 1][c - 1];
			}
			for (int j = c - 1; j > 0; j--) {
				arr2[down][j] = arr2[down][j - 1];
			}
			arr2[down][1] = 0;

			arr = arr2;
			arr2 = new int[r][c];
		}
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum + 2);
	}
}
