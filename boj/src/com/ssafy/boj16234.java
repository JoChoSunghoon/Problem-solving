package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj16234 { // boj16234 인구이동

	private static int[][] arr;
	private static boolean[][] check;
	private static int N, L, R, cnt = 1, ans = 0;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (cnt != 0) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check[i][j] = false;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!check[i][j]) {
						bfs(i, j);
					}
				}
			}
			ans++;
		}
		System.out.println(ans - 1);

	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		Stack<int[]> s = new Stack<int[]>();

		q.offer(new int[] { r, c });

		int sum = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			sum += arr[now[0]][now[1]];
			check[r][c] = true;
			s.add(now);

			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i]; // 개빡친다 이거 왜 못봤지;;; bfs 방향에서 변수 주의
				int y = now[1] + dy[i];
				if (x >= 0 && x < N && y >= 0 && y < N && !check[x][y]) {
					int diff = Math.abs(arr[x][y] - arr[now[0]][now[1]]);
					if (diff <= R && diff >= L) {
						q.offer(new int[] { x, y });
						check[x][y] = true;
						cnt++;
					}
				}
			}
		}

		int avg = sum / s.size();

		while (!s.empty()) {
			int[] now = s.pop();
			arr[now[0]][now[1]] = avg;
		}
	}
}
