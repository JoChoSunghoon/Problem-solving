package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj19237 { // boj19237 어른상어 gold3

	private static int n, m, k;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int[][] arr;
	private static int[][] priorDir = new int[4][4];
	private static Shark[] s;
	private static Queue<Shark> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		s = new Shark[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0) {
					s[arr[i][j] - 1] = new Shark(arr[i][j] - 1, i, j);
					arr[i][j] = k;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			s[i].setDir(Integer.parseInt(st.nextToken()) - 1);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					priorDir[j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
			s[i].setPrior(priorDir);
			q.offer(s[i]);
		}

		for (int t = 1; t <= 1000; t++) {
			int psize = q.size();

			if (psize == 1) {
				System.out.println(t);
				return;
			}
			System.out.println("##########"+t+"초");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}


			for (int i = 0; i < psize; i++) {
				Shark ss = q.poll();
				int dir = ss.dir;

				boolean out = false;
				boolean go = false;

				for (int d = 0; d < 4; d++) {
					int pdir = ss.prior[dir][d];
					int x = ss.x + dx[pdir];
					int y = ss.y + dy[pdir];
					if (x < 0 || x >= n || y < 0 || y >= n) {
						continue;
					}

					if (arr[x][y] == 0) {
						ss.x = x;
						ss.y = y;
						ss.dir = pdir;
						arr[x][y] = k + 1;
						q.offer(ss);
						go = true;
						break;
					} else if (arr[x][y] == k + 1) {
						System.out.println(t + "초에 " + ss.no + "사망");
						go = true;
						out = true;
						break;
					}
				}
				
				if (!go) {
					if (dir % 2 == 0) {
						dir++;
					} else {
						dir--;
					}
					ss.x = ss.x + dx[dir];
					ss.y = ss.y + dy[dir];
					ss.dir = dir;
					arr[ss.x][ss.y] = k + 1;
					q.offer(ss);
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0) {
						arr[i][j]--;
					}
				}
			}
		}

		System.out.println(-1);
	}

	static class Shark {
		int no;
		int x;
		int y;
		int dir;
		int[][] prior = new int[4][4];

		public Shark(int no, int x, int y) {
			super();
			this.no = no;
			this.x = x;
			this.y = y;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		public void setPrior(int[][] prior) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					this.prior[i][j] = prior[i][j];
				}
			}
		}
	}
}
