package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17136 { // boj17136 색종이 붙이기 Gold3 상, 탈출조건

	private static int[][] arr = new int[10][10];
	private static int[] paper = { 5, 5, 5, 5, 5 }; // 1,2,3,4,5크기 5장씩
	private static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(0); // 0행부터 시작

		if (ans == Integer.MAX_VALUE) { // 정답 갱신이 안되면 불가능
			ans = -1;
		}

		System.out.println(ans);
	}

	public static void func(int row) {

		for (int r = row; r < 10; r++) { // 격자를 돌아다니면서
			for (int c = 0; c < 10; c++) {
				if (arr[r][c] == 1) { // 1인경우
					for (int p = 0; p < 5; p++) { // 종이로 덮기 시작
						if (paper[p] > 0) { // 종이가 1개 이상 있고
							if (isPos(p, r, c)) { // 덮을 수 있는 조건을 충족하면
								setArr(r, c, p, 0); // 덮어라
								paper[p]--; // 덮은건 제외
								func(r); // 그리고 다시 반복
								setArr(r, c, p, 1); // 다 하고 나면 해제
								paper[p]++; // 종이도 반환
							}
						}
					}

					if (arr[r][c] == 1) { // 1인위의 종이의 경우를 못채우는 경우에는 불가능한 경우로 생각하고 바로 리턴
						return;
					}

				}
			}
		}

		int sum = 25; // 사용할 수 있는 종이의 최대 개수
		for (int i = 0; i < 5; i++) {
			sum -= paper[i]; // 남은 종이 제외
		}
		if (ans > sum) {
			ans = sum; // 정답 갱신
		}
	}

	public static void setArr(int r, int c, int num, int target) { // 덮는 함수
		for (int i = r; i <= r + num; i++) {
			for (int j = c; j <= c + num; j++) {
				arr[i][j] = target;
			}
		}
	}

	public static boolean isPos(int num, int r, int c) { // 덮을 수 있는지 확인하는 함수
		if (r + num >= 10 || c + num >= 10) {
			return false;
		}

		for (int i = r; i <= r + num; i++) {
			for (int j = c; j <= c + num; j++) {
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
