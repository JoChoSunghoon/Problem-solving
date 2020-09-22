package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

//queue 구현하면 100ms정도 빨라짐
public class boj7576 { //토마토
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] box = new int[n][m];

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		Queue<int[]> q = new LinkedList<int[]>();
		
		for (int i = 0; i < box.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < box[i].length; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					q.offer(new int[] { i, j, 0 }); // 시작점
				}
			}
		}

		int x, y, z = 0;
		

		while (!q.isEmpty()) {
			x = q.peek()[0]; // row
			y = q.peek()[1]; // col
			z = q.peek()[2]; // day
			q.poll();

			for (int i = 0; i < dx.length; i++) {
				int row = x + dx[i];
				int col = y + dy[i];
				if (row >= 0 && row < n && col >= 0 && col < m && box[row][col] == 0) { // 4방향 뻗어나가기, bfs
					box[row][col] = 1;
					q.offer(new int[] { row, col, z + 1 });
				}
			}
		}

		
		int ans = -1;
		boolean checkZero = false;

		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				if (box[i][j] == 0) {
					checkZero = true; // 모두 익지 못하는 상황
					break;
				}
			}
			if (checkZero) {
				break;
			}
		}
		if (!checkZero) {
			ans = z;
		}
		System.out.println(ans);
	}
}
