package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1251 { // swea1251 하나로

	private static int n;
	private static double e;
	private static long[] x;
	private static long[] y;
	private static int[] parents;
	private static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {

			n = Integer.parseInt(br.readLine());

			x = new long[n];
			y = new long[n];
			parents = new int[n];
			nodes = new Node[n * (n - 1) / 2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			e = Double.parseDouble(br.readLine());

			int idx = 0;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					long diffX = x[i] - x[j];
					long diffY = y[i] - y[j];
					nodes[idx++] = new Node(i, j, (long) (diffX * diffX + diffY * diffY));
				}
			}
			Arrays.sort(nodes);

			// make
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}

			long ans = 0;
			int cnt = 0;

			for (int i = 0; i < idx; i++) {
				Node now = nodes[i];
				if (union(now.from, now.to)) {
					ans += now.weight;
					cnt++;
				}
				if (cnt == n - 1) {
					break;
				}
			}

			sb.append("#" + test_case + " " + Math.round(ans * e) + "\n");
		}
		System.out.println(sb);
	}

	public static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return false;
		}

		parents[b] = a;
		return true;
	}

	static class Node implements Comparable<Node> {
		int from;
		int to;
		long weight;

		public Node(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}

	}
}
