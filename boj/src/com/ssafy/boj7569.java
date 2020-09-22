package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7569 { //토마토
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] dx = { 1, -1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, 1, -1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };

		int[][][] box = new int[n][m][h];

		Queue<int[]> q = new LinkedList<int[]>();

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						q.offer(new int[] { i, j, k, 0 });
					}
				}
			}
		}

		int x, y, z, d = 0;
		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			z = q.peek()[2];
			d = q.peek()[3];
			q.poll();

			for (int i = 0; i < 6; i++) {
				int row = x + dx[i];
				int col = y + dy[i];
				int height = z + dz[i];

				if (row >= 0 && row < n && col >= 0 && col < m && height >= 0 && height < h
						&& box[row][col][height] == 0) {
					box[row][col][height] = 1;
					q.offer(new int[] { row, col, height, d + 1 });
				}
			}
		}
		int ans = -1;
		boolean zeroCheck=false;
		
		for(int k=0;k<h;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(box[i][j][k]==0) {
						zeroCheck=true;
						break;
					}
				}
				if(zeroCheck) {
					break;
				}
			}
			if(zeroCheck) {
				break;
			}
		}
		
		if(!zeroCheck) {
			ans = d;
		}
		System.out.println(ans);
	}
}
