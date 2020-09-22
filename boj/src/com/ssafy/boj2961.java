package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2961 { // boj 2961 도영이가 만든 맛있는 음식
	private static int n;
	private static int[] a;
	private static int[] b;
	private static boolean[] check;
	private static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		check = new boolean[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			a[i] = Integer.parseInt(st.nextToken()); //신맛
			b[i] = Integer.parseInt(st.nextToken()); //쓴맛
		}

		cal(0, 1, 0);

		System.out.println(ans);
	}

	public static void cal(int start, int mul, int sum) {

		if (mul!=1 && sum!=0) { //재료를 사용할 경우 업데이트
			int diff = Math.abs(mul - sum);
			ans = Math.min(diff, ans);
		}

		for (int i = start; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				cal(i, mul * a[i], sum + b[i]);
				check[i] = false;
			}
		}
	}
}
