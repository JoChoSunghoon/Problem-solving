package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10830 { // boj10830 행렬 제곱 gold 4 상

	private static int n;
	private static long b;
	private static int[][] arr;
	private static int[][] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());

		arr = new int[n][n];
		res = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			res[i][i] = 1; // 정답은 항등행렬로 해서 1번만 곱할 수 있도록 하기
		}

		while (b > 0) { //b승만큼 반복
			if (b % 2 == 1) { //나머지가 1이면 
				res = exp(res, arr); // 1번만 곱하기
			}
			arr = exp(arr, arr); //2의 배수이면 제곱해서 arr 갱신
			
			b /= 2;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] exp(int[][] temp1, int[][] temp2) { // 행렬의 제곱
		int[][] brr= new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					brr[i][j] += temp1[i][k] * temp2[k][j];
				}
				brr[i][j] %= 1000;
			}
		}
		return brr;
	}
}
