package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2638 { // boj2638 치즈 gold 4

	private static int n, m;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					cnt++;
				}
			}
		}

		int ans = 0;

		while (true) {
			bfs();
			ans++;
			cnt -= melt();
			if(cnt==0) {
				break;
			}
		}
		
		System.out.println(ans);
	}

	private static int melt() {
		return 0;
	}

	private static void bfs() {
		for(int i=0;i<n;i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
