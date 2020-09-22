package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj4963 { //boj4963 섬의 개수
	private static int cnt;
	private static int w;
	private static int h;
	private static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	private static int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };
	private static int[][] area;
	private static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}

			area = new int[h][w];
			check = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
					check[i][j] = false;
				}
			}

			cnt = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!check[i][j] && area[i][j] == 1) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			ans.append(cnt + "\n");

		}
		System.out.println(ans);
	}

	private static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { row, col });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			check[now[0]][now[1]] = true;

			for (int i = 0; i < 8; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];

				if (x >= 0 && x < h && y >= 0 && y < w && !check[x][y] && area[x][y] == 1) {
					check[x][y] = true;
					q.offer(new int[] { x, y });
				}
			}
		}
	}
}
