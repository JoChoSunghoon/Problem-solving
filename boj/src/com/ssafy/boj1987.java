package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1987 { // boj 1987 알파벳 gold4 중, 조건 고려

	private static int r, c;
	private static int ans = 1;
	private static char[][] arr;
	private static boolean[] alphabet = new boolean[26]; // 알파벳 체크
	private static int[] dx = { -1, 1, 0, 0 }; // 4방향 탐색
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][];

		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		alphabet[arr[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(ans);
	}

	public static void dfs(int row, int col, int cnt) {
		if (cnt > ans) { // 최대값 갱신
			ans = cnt;
		}
		if (ans == 26) { // 어차피 최대 갯수
			return;
		}

		for (int i = 0; i < 4; i++) {
			int x = row + dx[i];
			int y = col + dy[i];
			if (x >= 0 && x < r && y >= 0 && y < c && !alphabet[arr[x][y] - 'A']) { // 알파벳 가능하면
				alphabet[arr[x][y] - 'A'] = true; // 진행
				dfs(x, y, cnt + 1);
				alphabet[arr[x][y] - 'A'] = false; // 진행후 원상복귀
			}
		}
	}

}
