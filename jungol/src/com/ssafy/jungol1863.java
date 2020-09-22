package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jungol1863 { // jungol 1863 종교

	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			union(a, b);
		}

		for (int i = 0; i < n; i++) {
			find(i);
		}

		Arrays.sort(parents);

		int ans = 1;
		int prev = parents[0];
		for (int i = 1; i < n; i++) {
			if (parents[i] != prev) {
				ans++;
				prev = parents[i];
			}
		}
		System.out.println(ans);

	} // end of main

	public static int find(int a) {
		if (parents[a] == a) {
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
		if (a < b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}
}// end of class
