package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea3289 { //swea 3289 서로소 집합

	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			ans.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			parents = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0) {
					union(a, b);
				}
				if (op == 1) {
					ans.append(checkParents(a,b));
				}
			}
			ans.append("\n");
		}
		System.out.println(ans);
	}// end of main

	public static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return;
		}
		parents[a] = b;
	}

	public static int checkParents(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return 1;
		}
		return 0;
	}

}// end of class
