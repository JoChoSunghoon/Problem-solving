package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3190 {
	private static int n;
	private static int k;
	private static int l;
	private static int ans;
	private static int[][] arr;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	private static boolean isPos = true;
	private static Queue<int[]> pos = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		arr[0][0] = 1;
		pos.offer(new int[] { 0, 0 });

		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = 2;
		}

		l = Integer.parseInt(br.readLine());

		int sx = 0;
		int sy = 0;
		int lx = 0;
		int ly = 0;

		int d = 0;

		int start = 0;
		int end = 0;

		for (int i = 0; i <= l; i++) {
			String dir = "D";
			if (i != l) {
				st = new StringTokenizer(br.readLine());
				end = Integer.parseInt(st.nextToken());

				dir = st.nextToken();
			} else {
				end = n * n;
			}

			for (int j = start; j < end; j++) {
				sx += dx[d];
				sy += dy[d];

				ans=j;
				if (sx < 0 || sx >= n || sy < 0 || sy >= n) {
					isPos = false;
					break;
				}
				
				if (arr[sx][sy] == 1) {
					isPos = false;
					break;
				}

				if (arr[sx][sy] == 2) {
					arr[sx][sy] = 1;
					pos.offer(new int[] { sx, sy });
				} else {
					arr[sx][sy] = 1;
					arr[lx][ly] = 0;
					pos.poll();
					pos.offer(new int[] { sx, sy });

					if (pos.size() > 1) {
						lx = pos.peek()[0];
						ly = pos.peek()[1];
					} else {
						lx = sx;
						ly = sy;
					}

				}
			}
			if (!isPos) {
				break;
			}

			switch (dir) {
			case "D":
				d = (d + 1) % 4;
				break;
			case "L":
				d = (d + 3) % 4;
				break;

			default:
				break;
			}

			start = end;
		}

		System.out.println(ans);
	}
	
}
