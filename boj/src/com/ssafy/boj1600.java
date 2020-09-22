package com.ssafy;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1600 { //boj1600 말이되고싶은 원숭이 gold5
	private static int K, H, W;

	private static int[][] arr;
	private static boolean[][][] check; // row, col, k

	private static final int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2, -1, 1, 0, 0 };
	private static final int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1, 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        arr = new int[H][W];
        check = new boolean[H][W][K+1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, K, 0 });
		check[0][0][K] = true;

		int start;
		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == H - 1 && now[1] == W - 1) {
				System.out.println(now[3]);
				return;
			}

			if (now[2] > 0) { // 점프
				start = 0;
			} else { // 점프 못함
				start = 8;
			}

			for (int i = start; i < 12; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if (x >= 0 && x < H && y >= 0 && y < W && arr[x][y] == 0) {
					if (i >= 8) { // 점프 아닐 때
						if (!check[x][y][now[2]]) {
							check[x][y][now[2]] = true;
							q.offer(new int[] { x, y, now[2], now[3] + 1 });
						}
					} else {
						if (!check[x][y][now[2] - 1]) {
							check[x][y][now[2] - 1] = true;
							q.offer(new int[] { x, y, now[2] - 1, now[3] + 1 });
						}
					}
				}
			}
		}

		System.out.println(-1);
	}
}
