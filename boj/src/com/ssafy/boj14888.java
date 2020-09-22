package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888 { //boj14888 연산자 끼워넣기,하, 순열만들기 문제

	private static int[] num;
	private static char[] oper;
	private static char[] copyOp;
	private static boolean[] check;
	private static char[] op = { '+', '-', '*', '/' };
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		num = new int[n];
		oper = new char[n - 1];
		copyOp = new char[n - 1];
		check = new boolean[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				oper[idx++] = op[i];
			}
		}
		perm(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	public static void perm(int cnt) {
		if (cnt == n - 1) {
			int res = num[0];
			for (int i = 0; i < n - 1; i++) {
				res = calculate(res,num[i+1],copyOp[i]);
			}
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			copyOp[cnt] = oper[i];
			perm(cnt + 1);
			check[i] = false;
		}
	}

	public static int calculate(int a, int b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else if (op == '*') {
			return a * b;
		} else {
			return a / b;
		}
	}
}
