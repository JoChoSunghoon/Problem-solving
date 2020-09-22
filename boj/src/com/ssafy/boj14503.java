
package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503 { //boj14503 로봇 청소기, 중, 4방향 dfs, 조건 만족시 dfs종료 조선에서 헤맴
	private static int n, m, startX, startY, startDir, ans;
	private static int[][] arr;
	private static int[] dx = { -1, 0, 1, 0 }; // 북 동 남 서
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		startDir = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(startX,startY,startDir);
	}
	public static void dfs(int r, int c, int d) {
		if (arr[r][c] == 0) {
			ans++;
			arr[r][c] = 2;
		}

		for (int i = 0; i < 4; i++) {
			int tempDir = (d + 3 - i) % 4;
			int x = r + dx[tempDir];
			int y = c + dy[tempDir];
			if (x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0) {
				dfs(x, y, tempDir);
			}
		}
		int x = r + dx[(d+2)%4];
		int y = c + dy[(d+2)%4];
		
		if(arr[x][y]==1) {
			System.out.println(ans);
			System.exit(0);
		}
		dfs(x,y,d);
	}

}
