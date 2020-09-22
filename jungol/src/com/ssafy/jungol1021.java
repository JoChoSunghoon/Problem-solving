package com.ssafy;

import java.util.Scanner;

public class jungol1021 { // 장난감조립 19MB 428ms

	private static int[][] part;
	private static int[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		part = new int[m][3];
		ans = new int[n + 1];
		
		for (int i = 0; i < part.length; i++) {
			for (int j = 0; j < 3; j++) {
				part[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < part.length; i++) {
			if (part[i][0] == n) {
				assemble(part[i][1], part[i][2]);
			}
		}

		for (int i = 0; i < ans.length; i++) {
			if (ans[i] != 0) {
				System.out.println(i+ " " +ans[i]);
			}
		}
	}

	private static void assemble(int cur, int cnt) {
		boolean check = false;

		for (int i = 0; i < part.length; i++) {
			if (part[i][0] == cur) {
				check = true;
				break;
			}
		}
		if (check == false) {
			ans[cur] += cnt;
		} else {
			for (int i = 0; i < part.length; i++) {
				if (part[i][0] == cur) {
					for (int j = 0; j < cnt; j++) {
						assemble(part[i][1], part[i][2]);
					}
				}
			}
		}
	}
}
