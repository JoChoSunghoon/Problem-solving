package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea9229 { //한빈이와 Spot Mart
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			int[][] snack = new int[n][n];

			int ans = -1;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					snack[i][j] = arr[i] + arr[j];
					if (snack[i][j] <= m && snack[i][j] > ans) {
						ans = snack[i][j];
					}
				}
			}
			sb.append("#" + test_case + " " + ans + "\n");
		}
		System.out.println(sb);
	}// end of main
}// end of class
