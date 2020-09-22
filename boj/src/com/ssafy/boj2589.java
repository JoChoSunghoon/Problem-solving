package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2589 { // boj 2589 보물섬 gold5
	private static int h, w;
	private static int ans;
	private static char[][] arr;
	private static boolean[][] check;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		arr = new char[h][w];

		for (int i = 0; i < arr.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}

		System.out.println(ans - 1);
	}

	private static void bfs(int r, int c) {
		check = new boolean[h][w];
		Queue<int[]> temp = new LinkedList<>();
		temp.offer(new int[] { r, c });
		check[r][c] = true;
		int level = 0;

		while (!temp.isEmpty()) {
			int size = temp.size();
			level++;
			for (int j = 0; j < size; j++) {

				int[] now = temp.poll();
				r = now[0];
				c = now[1];

				for (int i = 0; i < 4; i++) {
					int x = r + dx[i];
					int y = c + dy[i];
					if (x >= 0 && x < h && y >= 0 && y < w && !check[x][y] && arr[x][y] == 'L') {
						temp.offer(new int[] { x, y });
						check[x][y] = true;
					}
				}
			}
		}

		if (level > ans) {
			ans = level;
		}
	}
}
