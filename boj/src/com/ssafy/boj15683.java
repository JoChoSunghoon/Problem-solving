package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15683 { // boj15683 미완
	private static int[][] arr = new int[8][8];
	private static CCTV[] cctv = new CCTV[8];
	private static int cctvIdx;
	private static int n, m;
	private static int ans = 64;
	private static int[] dir = { 4, 2, 4, 4, 1 }; // 카메라 번호별 살펴볼 방향 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					cctv[cctvIdx++] = new CCTV(i,j,arr[i][j]);
				}
			}
		}

		dfs(0);

		System.out.println(ans);
	}// end of main

	public static void dfs(int now) {
		if (now == cctvIdx) {
			int temp = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0) {
						temp++;
					}
				}
			}
			if (temp < ans) {
				ans = temp;
			}
			return;
		}

		int num = cctv[now].num;
		int[][] origin = new int[8][8];

		for (int i = 0; i < dir[num - 1]; i++) {
			for(int ii=0;ii<n;ii++) {
				for(int j=0;j<m;j++) {
					origin[ii][j] = arr[ii][j];
				}
			}
			if (num == 1) {
				rotateCCTV(i, cctv[now]);
			} else if (num == 2) {
				rotateCCTV(i, cctv[now]);
				rotateCCTV(i + 2, cctv[now]);
			} else if (num == 3) {
				rotateCCTV(i, cctv[now]);
				rotateCCTV(i + 1, cctv[now]);
			} else if (num == 4) {
				rotateCCTV(i, cctv[now]);
				rotateCCTV(i + 1, cctv[now]);
				rotateCCTV(i + 2, cctv[now]);
			} else if (num == 5) {
				rotateCCTV(i, cctv[now]);
				rotateCCTV(i + 1, cctv[now]);
				rotateCCTV(i + 2, cctv[now]);
				rotateCCTV(i + 3, cctv[now]);
			}
			dfs(now + 1);
			for(int ii=0;ii<n;ii++) {
				for(int j=0;j<m;j++) {
					arr[ii][j] = origin[ii][j];
				}
			}
		}
	}

	public static void rotateCCTV(int dir, CCTV cctv) {
		dir %= 4;

		if (dir == 0) {
			for (int i = cctv.r + 1; i < n; i++) {
				if (arr[i][cctv.c] == 6) {
					break;
				}
				arr[i][cctv.c] = -1;// 간 곳 체크
			}
		} else if (dir == 1) {
			for (int i = cctv.c - 1; i >= 0; i--) {
				if (arr[cctv.r][i] == 6) {
					break;
				}
				arr[cctv.r][i] = -1;// 간 곳 체크
			}
		} else if (dir == 2) {
			for (int i = cctv.r - 1; i >= 0; i--) {
				if (arr[i][cctv.c] == 6) {
					break;
				}
				arr[i][cctv.c] = -1;// 간 곳 체크
			}
		} else if (dir == 3) {
			for (int i = cctv.c + 1; i < m; i++) {
				if (arr[cctv.r][i] == 6) {
					break;
				}
				arr[cctv.r][i] = -1;// 간 곳 체크
			}
		}
	}

	static class CCTV {
		int r;
		int c;
		int num;

		public CCTV(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
}
