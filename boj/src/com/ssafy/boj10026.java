package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10026 { // boj10026 적록색약
	private static int n;
	private static char[][] arr;
	private static boolean[][] check;
	private static int ans1, ans2;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new char[n][n];
		check = new boolean[n][n];

		String s;
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) {
					ans1++;
					check[i][j] = true;
					dfs(i, j, arr[i][j]);
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				check[i][j]=false;
				if(arr[i][j]=='R') {
					arr[i][j]='G';
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) {
					ans2++;
					check[i][j] = true;
					dfs(i, j, arr[i][j]);
				}
			}
		}
		System.out.print(ans1+" "+ans2);
	}

	public static void dfs(int r, int c, char target) {
		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			if (x >= 0 && x < n && y >= 0 && y < n && !check[x][y] && arr[x][y] == target) {
				check[x][y] = true;
				dfs(x, y, target);
			}
		}
	}
}
