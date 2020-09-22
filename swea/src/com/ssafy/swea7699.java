package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea7699 { // swea7699 수지의 수지 맞는 여행 D4

	private static int r, c;
	private static char[][] arr = new char[20][20];

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	private static int ans = 0;
	private static boolean[] check = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				for (int j = 0; j < c; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			for (int i = 0; i < 26; i++) {
				check[i] = false;
			}
			check[arr[0][0] - 'A'] = true;
			ans = 1;

			dfs(0, 0, 1);
			answer.append("#"+test_case+" "+ans+"\n");
		}
		System.out.println(answer);
	}

	private static void dfs(int nx, int ny, int cnt) {
		if (cnt > ans) {
			ans = cnt;
		}

		if (ans == 26) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int x = nx + dx[i];
			int y = ny + dy[i];
			if (x >= 0 && x < r && y >= 0 && y < c && !check[arr[x][y] - 'A']) {
				check[arr[x][y] - 'A'] = true;
				dfs(x, y, cnt + 1);
				check[arr[x][y] - 'A'] = false;
			}
		}
	}
}
