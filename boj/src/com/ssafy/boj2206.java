package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206 { // 벽 부수고 이동하기
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static boolean[][][] check;
	private static char[][] map;
	private static int ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		check = new boolean[n][m][2];

		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { 0, 0, 0, 1 });
		check[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == n - 1 && now[1] == m - 1) {
				ans = now[3];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];

				if (x >= 0 && x < n && y >= 0 && y < m && !check[x][y][now[2]]) {
					if (map[x][y] == '0') { // 0인경우
						check[x][y][now[2]] = true;
						q.offer(new int[] { x, y, now[2], now[3] + 1 });
					} else { // 벽을 만남
						if (now[2] == 0) { // 벽을 안뚫었으면 진행
							check[x][y][1] = true;
							q.offer(new int[] { x, y, 1, now[3] + 1 });
						}
					}
				}
			}
		}

		System.out.println(ans);
	}
}
