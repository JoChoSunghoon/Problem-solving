package com.ssafy;

import java.util.Scanner;

public class swea7393 { // swea 7393 대규의 팬덤활동

	private static long[][][] num = new long[101][10][1024]; // [1<=n<=100][0~9][0~9사용 여부]

	private static int MOD = 1000000000;

	public static void main(String[] args) { 
		for (int i = 1; i < 10; i++) { //0을 제외한 나머지 공을 시작위치에
			num[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 1024; k++) {
					int visit = (k | (1 << j));

					if (j == 0) {
						num[i][j][visit] += num[i - 1][j + 1][k];
					} else if (j == 9) {
						num[i][j][visit] += num[i - 1][j - 1][k];
					} else {
						num[i][j][visit] += num[i - 1][j - 1][k] + num[i - 1][j + 1][k];
					}
					num[i][j][visit] %= MOD;
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();

		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			
			long sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += num[n][j][1023];
			}
			sum %= MOD;

			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}

		System.out.println(sb);
	}
}
