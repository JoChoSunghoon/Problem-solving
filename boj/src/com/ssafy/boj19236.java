package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj19236 { // boj19236 청소년 상어 gold3

	private static int[][] arr = new int[4][4];
	private static Fish[] fish = new Fish[17];
	private static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 반시계 12시부터 시작
	private static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int no = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				arr[i][j] = no;
				fish[no] = new Fish(i, j, dir, true);
			}
		}

		int now = arr[0][0];
		arr[0][0] = -1; // 상어 위치
		fish[now].isLive = false;

		dfs(0, 0, fish[now].dir, now);

		System.out.println(ans);
	}

	public static void dfs(int x, int y, int dir, int sum) {
		int[][] brr = new int[4][4];
		Fish[] f = new Fish[17];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				brr[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < 17; i++) {
			f[i] = fish[i];
		}

		simulation();

		for (int i = 1; i < 4; i++) { //먹을 수 있는 경우에서는 같은 맵
			int nx = x + dx[dir] * i;
			int ny = y + dy[dir] * i;
			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
				if (arr[nx][ny] == 0) {
					continue;
				}
				arr[x][y] = 0; // 먹고 빈 곳
				int now = arr[nx][ny];
				arr[nx][ny] = -1; // 상어 위치
				fish[now].isLive = false;
				dfs(nx, ny, fish[now].dir, sum + now);
				arr[nx][ny] = now; // 복귀
				fish[now].isLive = true;
				arr[x][y] = -1; // 상어 위치 복귀
			} else {
				break;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = brr[i][j];
			}
		}

		for (int i = 0; i < 17; i++) {
			fish[i] = f[i];
		}

		if (ans < sum) {
			ans = sum;
		}
	}

	public static void simulation() {
		for (int i = 1; i < 17; i++) {
			if (!fish[i].isLive) {
				continue;
			}

			Fish now = fish[i];

			for (int d = 0; d < 8; d++) {
				int dir = (now.dir + d) % 8;
				int x = now.x + dx[dir];
				int y = now.y + dy[dir];
				if (x >= 4 || x < 0 || y >= 4 || y < 0 || arr[x][y] == -1) {
					continue;
				}
				int no = arr[x][y];
				arr[x][y] = arr[now.x][now.y];
				arr[now.x][now.y] = no;

				fish[i] = new Fish(x, y, dir, true);
				if (no > 0) {
					fish[no] = new Fish(now.x, now.y, fish[no].dir, true);
				}
				break;
			}
		}
	}

	static class Fish {
		int x;
		int y;
		int dir;
		boolean isLive;

		public Fish(int x, int y, int dir, boolean isLive) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.isLive = isLive;
		}
	}

}
