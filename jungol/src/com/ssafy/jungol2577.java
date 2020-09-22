package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jungol2577 { // jungol 2577 회전 초밥
	private static int n, d, k, c;
	private static int[] dishes;
	private static int[] sushi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		dishes = new int[n];
		sushi = new int[d + 1];

		sushi[c - 1]++;
		int cnt = 1;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < n + k - 1; i++) {
			if (i < k - 1) {
				if (sushi[dishes[i] - 1] == 0) {
					cnt++;
				}
				sushi[dishes[i] - 1]++;
			} else {
				if (sushi[dishes[i % n] - 1] == 0) {
					cnt++;
				}
				sushi[dishes[i % n] - 1]++;

				ans = Math.max(ans, cnt);

				if (sushi[dishes[i - k + 1] -1] > 0) {
					sushi[dishes[i - k + 1] -1]--;
					if (sushi[dishes[i - k + 1] -1] == 0) {
						cnt--;
					}
				}
			}
		}

		System.out.println(ans);
	}
}
