package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2580 { // boj2580 스도쿠 Gold4 중, 스도쿠 조건 여부 확인
	private static int[][] arr = new int[9][9];
	private static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				if (num == 0) {
					list.add(new int[] { i, j }); // 0인 지점 저장
				}
			}
		}

		func(0);

	}

	public static void func(int cnt) {
		if (cnt > list.size()) { //종료 조건
			return;
		}
		if (cnt == list.size()) { //끝까지 가서 가능한 경우 1번 출력하고 종료
			if (check()) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(arr[i][j] + " ");
					}
					System.out.println();
				}
				System.exit(0);
			}
			return;
		}
		int[] now = list.get(cnt);

		for (int i = 1; i < 10; i++) {
			if (isPos(i, now[0], now[1])) { // 넣을 수 있는 숫자를 확인하고
				arr[now[0]][now[1]] = i; // 가능하면 넣고
				func(cnt + 1); // 재귀
				arr[now[0]][now[1]] = 0; // 아니면 원상복귀
			}
		}
	}

	private static boolean isPos(int num, int r, int c) { // 0에 숫자 넣을 수 있는 지 확인

		for (int i = 0; i < 9; i++) {
			if (num == arr[r][i] || num == arr[i][c]) {
				return false;
			}
		}

		r = r / 3 * 3;
		c = c / 3 * 3;

		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (num == arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean check() { // 스도쿠 조건 만족 확인
		for (int i = 0; i < 9; i++) {
			int garo = 0;
			int sero = 0;
			for (int j = 0; j < 9; j++) {
				garo += arr[i][j];
				sero += arr[j][i];
			}
			if (garo != 45 || sero != 45) {
				return false;
			}
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				int sum = arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2] + arr[i + 1][j + 2] + arr[i][j + 2];
				if (sum != 45) {
					return false;
				}
			}
		}

		return true;
	}
}
