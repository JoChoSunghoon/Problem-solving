package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17135 { // Main_백준_1713_캐슽디펜스_조성훈

	private static int n, m, d, ans, res;
	private static int[][] arr = new int[16][15];
	private static int[][] arr2 = new int[16][15];
	private static int[] dx = { 0, -1, 0 }; // 좌 상 우 방향
	private static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		int sniperRow = n;
		for (int i = 0; i < n; i++) { // n은 궁수 자리
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr2[i][j] = arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m - 2; i++) {
			for (int j = i + 1; j < m - 1; j++) {
				for (int k = j + 1; k < m; k++) { // 궁수의 조합

					ans = 0; //적 처치 수 초기화
					sniperRow = n; // 궁수열 초기화

					for (int a = 0; a < n; a++) { // 맵 초기화
						for (int b = 0; b < m; b++) {
							arr[a][b] = arr2[a][b];
						}
					} 

					while (sniperRow != 0) {
						bfs(sniperRow - 1, i, 1); // 궁수별로  bfs 돌리기
						bfs(sniperRow - 1, j, 1);
						bfs(sniperRow - 1, k, 1);

						for (int a = 0; a < n; a++) { // 적 죽이기
							for (int b = 0; b < m; b++) {
								if (arr[a][b] == 2) {
									arr[a][b] = 0;
									ans++;
								}
							}
						}
						sniperRow--; // 궁수열 1칸 올리기
					}

					if (ans > res) { // 최대값 갱신
						res = ans;
					}
				}
			}
		}

		System.out.println(res);
	}

	public static void bfs(int r, int c, int dist) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] check = new boolean[n][m];

		q.offer(new int[] { r, c, dist }); // 해당 지점까지의 거리

		while (!q.isEmpty()) {
			
			int[] now = q.poll();
			check[now[0]][now[1]] = true;
			
			if (now[2] > d) { // 거리 넘어가면 볼 필요 없음
				continue;
			}
			
			if (arr[now[0]][now[1]] == 1 && now[2] <= d) { // 왼쪽이면서 거리 최소
				arr[now[0]][now[1]] = 2; // 일단 맞은 표시
				return;
			} else if (arr[now[0]][now[1]] == 2 && now[2] <= d) { // 동시공격일 경우, 즉 누가 쏜거다 그래도 나간다.
				return;
			}
			for (int i = 0; i < 3; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if (x < n && x >= 0 && y >= 0 && y < m && !check[x][y]) {
					q.offer(new int[] { x, y, now[2] + 1 });
					check[x][y] = true;
				}
			}
		}
	}
}