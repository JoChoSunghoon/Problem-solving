package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 { // boj5014 스타트링크 gold5

	private static int f, s, g, u, d;
	private static int ans = Integer.MAX_VALUE;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		visited = new boolean[f + 1];

		visited[0] = true;
		visited[s] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { s, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == g) {
				ans = now[1];
				break;
			}

			if (now[0] + u <= f && !visited[now[0] + u]) {
				visited[now[0] + u] = true;
				q.offer(new int[] { now[0] + u, now[1] + 1 });
			}
			if (now[0] - d >= 1 && !visited[now[0] - d]) {
				visited[now[0] - d] = true;
				q.offer(new int[] { now[0] - d, now[1] + 1 });
			}
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}
}
