package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj16938 { // boj16938 캠프준비 gold 4
	private static int n, l, r, x, ans;
	private static int[] difficult;
	private static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		difficult = new int[n];
		visit = new boolean[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			difficult[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(difficult);

		subSet(0);
		
		System.out.println(ans);
	}

	public static void subSet(int idx) {
		if (idx >= n) {
			int cnt = 0;
			int sum = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					cnt++;
					sum += difficult[i];
					if (min > difficult[i]) {
						min = difficult[i];
					}
					if (max < difficult[i]) {
						max = difficult[i];
					}
				}
			}
			if(cnt >= 2 && l <= sum && sum <= r && max - min >= x) {
				ans++;
			}
			
			return;
		}
		visit[idx] = false;
		subSet(idx + 1);
		visit[idx] = true;
		subSet(idx + 1);
	}
}
