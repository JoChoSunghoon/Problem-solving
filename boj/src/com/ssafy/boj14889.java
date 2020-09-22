package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14889 { // boj 14889 스타트와 링크
	private static int n;
	private static int ans = Integer.MAX_VALUE;
	private static int[] teamA; //팀 저장 배열
	private static int[] teamB; //탐 저장 배열
	private static boolean[] check; // 방문 여부 확인
	private static int[][] arr; // 팀 시너지 저장

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		teamA = new int[n / 2];
		teamB = new int[n / 2];
		check = new boolean[n];

		StringTokenizer st;
		int num;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				num = Integer.parseInt(st.nextToken());
				arr[i][j] += num;
				arr[j][i] += num; // 나중에 한쪽만 더하기 위해서
			}
		}

		dfs(0, 0);

		System.out.println(ans);

	}

	//재귀로 조합 작성
	private static void dfs(int now, int cnt) {
		if (cnt == n / 2) {
			int aIdx = 0;
			int bIdx = 0;

			for (int i = 0; i < n; i++) {
				if (check[i]) {
					teamA[aIdx++] = i;
				} else {
					teamB[bIdx++] = i;
				}
			}

			int sumA = sumTeam(teamA);
			int sumB = sumTeam(teamB);

			ans = Math.min(ans, Math.abs(sumA - sumB));

			return;
		}
		for (int i = now; i < n; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			dfs(i, cnt + 1);
			check[i] = false;
		}

	}

	private static int sumTeam(int[] temp) {
		int sum = 0;
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				sum += arr[temp[i]][temp[j]]; // 한쪽만 더하기
			}
		}
		return sum;
	}

}
