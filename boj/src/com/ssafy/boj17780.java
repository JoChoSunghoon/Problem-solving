package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj17780 {
	private static int n, k;
	private static int[][] board;
	private static List<Integer>[][] boardState;
	private static Chess[] chess;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		boardState = new LinkedList[n][n];
		chess = new Chess[k + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				boardState[i][j] = new LinkedList<>();
			}
		}

		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			chess[i] = new Chess(x, y, dir);
			boardState[x][y].add(i);
		}

		for (int t = 1; t <= 1000; t++) {
			for (int i = 1; i <= k; i++) {
				Chess now = chess[i];
				int x = now.x;
				int y = now.y;

				// 가장 아래쪽 말이 아니라면 PASS
				if (boardState[x][y].get(0) != i)
					continue;

				int nx = x + dx[now.dir];
				int ny = y + dy[now.dir];

				// 말이 이동하려는 칸이 파란색인 경우 + 체스판을 벗어나는 경우
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 2) {
					// 방향 반대로
					if (now.dir % 2 == 0) {
						now.dir = now.dir + 1;
					} else {
						now.dir = now.dir - 1;
					}
					nx = x + dx[now.dir];
					ny = y + dy[now.dir];
				}

				// 방향을 반대로 한 후에 이동하려는 칸이 파란색인 경우
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 2) {
					continue;
				}
				// 말이 이동하려는 칸이 빨간색인 경우
				else if (board[nx][ny] == 1) {
					// 순서를 반대로 모든 말이 이동
					for (int j = boardState[x][y].size() - 1; j >= 0; j--) {
						int tmp = boardState[x][y].get(j);
						boardState[nx][ny].add(tmp);
						chess[tmp].x = nx;
						chess[tmp].y = ny;
					}
					boardState[x][y].clear();
				}
				// 말이 이동하려는 칸이 흰색인 경우
				else {
					// 모든 말이 이동
					for (int j = 0; j < boardState[x][y].size(); j++) {
						int tmp = boardState[x][y].get(j);
						boardState[nx][ny].add(tmp);
						chess[tmp].x = nx;
						chess[tmp].y = ny;
					}
					boardState[x][y].clear();
				}

				// 이동한 곳에 말이 4개 이상 있는가?
				if (boardState[nx][ny].size() >= 4) {
					System.out.println(t);
					return;
				}

			}
		}
		System.out.println(-1);
	}

	static class Chess {
		int x;
		int y;
		int dir;

		public Chess(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}