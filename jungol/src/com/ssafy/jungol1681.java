package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol1681 { // jungol1681 해밀턴 순환회로

	private static int n;
	private static int[][] adjMatrix;
	private static boolean[] visited;
	private static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());

		adjMatrix = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0]=true;
		dfs(0,0,0);
		
		System.out.println(ans);
	}

	public static void dfs(int cnt, int node, int cost) {
		if (cnt == n - 1) { // 마지막에 도착하면
			if (adjMatrix[node][0] != 0 && ans > cost + adjMatrix[node][0]) { // 시작점과 연결되어 있고 최소값 갱신이 가능하면
				ans = cost + adjMatrix[node][0]; // 정답 갱신
			}
			return;
		}

		for (int i = 1; i < n; i++) { // 시작 위치 다음부터
			if (visited[i] || adjMatrix[node][i] == 0) { // 방문했거나 연결되지 않으면 통과
				continue;
			}

			if (cost + adjMatrix[node][i] > ans) { // 이미 정답 보다 크면 통과
				continue;
			}

			visited[i] = true; // 방문 체크
			dfs(cnt + 1, i, cost + adjMatrix[node][i]); // 다음으로 넘어가기
			visited[i] = false; // 백트랙킹
		}
	}
}
