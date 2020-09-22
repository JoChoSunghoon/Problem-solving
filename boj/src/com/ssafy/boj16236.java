package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16236 { // boj13236 아기상어

	private static int n;
	private static int ans;
	private static int[] dx = { -1, 0, 0, 1 };
	private static int[] dy = { 0, -1, 1, 0 };
	private static int[][] arr;
	private static boolean[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		arr = new int[n][n];
		check = new boolean[n][n];

		int sx = -1;
		int sy = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 9) {
					sx = i;
					sy = j;
				}
			}
		}

		bfs(sx, sy);

		System.out.println(ans);

	}

	public static void bfs(int sx, int sy) {
		int sharksize = 2;
		int sharkeat = 0;
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> fish = new ArrayList<>();
		boolean[][] visit = new boolean[n][n];
		q.add(new Point(sx, sy)); 
		visit[sx][sy] = true;

		int time = 0;
		while (!q.isEmpty()) {

			int qSize = q.size();
			for (int s = 0; s < qSize; s++) { 

				Point p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n || visit[nx][ny] || arr[nx][ny]>sharksize)
                        continue;
                    
                    q.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                    if(arr[nx][ny]!=0 && arr[nx][ny]<sharksize) { 
                        fish.add(new Point(nx,ny));
                    }

				}
			} // 1초
			time++;

			if (fish.size() != 0) { 
				Collections.sort(fish); 
				Point meal = fish.get(0);
				fish.clear();
				sharkeat++;
				if (sharksize == sharkeat) {
					sharksize++;
					sharkeat = 0;
				}

				arr[sx][sy] = 0;
				sx = meal.x; 
				sy = meal.y;
				arr[sx][sy] = 9; 

				q.clear();
				q.add(meal); 
				ans += time; 
				time = 0; 
				for (int i = 0; i < n; i++) { 
					Arrays.fill(visit[i], false);
				}
				visit[meal.x][meal.y] = true;
			}

		} 
	}

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x) {
				return this.y - o.y;
			} else {
				return this.x - o.x;
			}
		}

	}
}
