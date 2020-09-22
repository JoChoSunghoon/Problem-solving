package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class swea1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] list = new ArrayList[101];
			boolean[] check = new boolean[101];

			for (int i = 0; i < 101; i++) {
				list[i] = new ArrayList<Integer>();
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n / 2; i++) { // 간선 추가
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}

			int ans = -1;
			int ansTime = -1;

			Queue<int[]> q = new LinkedList<>(); // bfs 시작

			q.offer(new int[] { start, 0 }); //시작 노드, 진행된 시간
			check[start] = true; //방문 체크
			while (!q.isEmpty()) {
				int[] now = q.poll();

				if (ansTime == now[1] && ans < now[0]) {  // 진행된 시간이 같은경우 큰 값으로
					ans = now[0];
				} else if (ansTime < now[1]) { // 더 진행된 경우는 그 값으로
					ans = now[0];
					ansTime = now[1];
				}

				for (int i : list[now[0]]) {
					if (!check[i]) { // 방문 안한곳으로 확산
						check[i] = true;
						q.offer(new int[] { i, now[1] + 1 });
					}
				}
			}

			sb.append("#" + test_case + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
