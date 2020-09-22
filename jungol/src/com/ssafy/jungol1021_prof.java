package com.ssafy;

import java.util.Scanner;

public class jungol1021_prof {

	public static int[][] map; // 메모이제이션 미활용 460ms

	// 메모이제이션을 통한 중복연산 줄이기
	// 제품을 만들기 위해 필욯나 기본부품을 계산한 결과를 저장
	// 0번은 0:계산 안한 상태, -1:계산함 (중간부품), -2:계산함(기본부품)
	public static int[][] result; // 메모이제이션 활용 354ms

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N 완제품
		int M = sc.nextInt(); // 정보의 수

		map = new int[N + 1][N + 1]; // 0번은 안씀
//		row 제품을 만드는데 col 부품이 필요한 개수를 저장할 배열

		for (int i = 0; i < M; i++) {
			int X = sc.nextInt(); // X를 만드는데 부품 Y가 K개 필요하다
			int Y = sc.nextInt();
			int K = sc.nextInt();
			map[X][Y] = K;
		}

//		int[] result = search(N);
//
//		for (int i = 1; i < result.length; i++) {
//			if (result[i] != 0) {
//				System.out.println(i + " " + result[i]);
//			}
//		}

		// 메모이제이션
		result = new int[N + 1][N + 1];
		search(N);
		for (int i = 1; i < result.length; i++) {
			if (result[N][i] != 0) {
				System.out.println(i + " " + result[N][i]);
			}
		}

	}

	/**
	 * 제품을 만들기 위해 필요한 기본 부품의 배열을 리턴하는 메서드 0번은 0:계산 안한 상태, -1:계산함 (중간부품),
	 * -2:계산함(기본부품)
	 */
	/*
	public static int[] search(int n) {
		int[] result = new int[map.length + 1]; // n번째 제품을 만들기 위해 필요한 기본 부품
		result[0] = -2; // 계산함표시 (기본부품)

		for (int i = 0; i < map.length; i++) {
			if (map[n][i] != 0) { // 사용한 부품이 있다면, 기본부품은 아님
				int[] val = search(i); // 재귀함수 호출
				if (val[0] == -2) { // 기본 부품이면
					result[i] += map[n][i];
				} else {// 중간 부품이면
					for (int j = 0; j < map.length; j++) {
						result[j] += map[n][i] * val[j];
					}
				}
				result[0] = -1;// 계산함표시(중간부품)
			}
		}

		return result;
	}
	*/
	
	/** 제품을 만들기 위해 필요한 기본 부품의 배열을 계산해서 전역변수에 저장하는 메서드 */
	public static void search(int n) {
		if (result[n][0] < 0) { // 계산을 이미 했다면
			return;
		}
		for (int i = 1; i < map.length; i++) {// 사용한 부품이 있다면, 기본부품은 아님
			if (map[n][i] != 0) {
				search(i); // 재귀함수 호출, 하위 부품을 탐색 result[i]행에는 값이 완성되어 있음
				if (result[i][0] == -2) {
					result[n][i] += map[n][i];
				} else {// 중간 부품이면
					for (int j = 0; j < map.length; j++) {
						result[n][j] += map[n][i] * result[i][j];
					}
				}
				result[n][0] = -1; // 계산함표시(중간부품)
			}
		}
	}
}
