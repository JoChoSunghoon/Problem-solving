package com.ssafy;

import java.util.Scanner;

public class boj9663 { // boj9663 N-Queen gold5
	private static int N;
	private static int[] col;
	private static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		col = new int[N + 1];
		
		setQueens(1);
		
		System.out.println(ans);
	}

	// 퀸을 현재(rowNo) 행에 놓기
	public static void setQueens(int rowNo) {

		if (rowNo > N) { // 가능한 경우만 따라왔으므로 정답 가능
			ans++;
			return;
		}

		// 가능한 선택지 (1열 ~ N열)
		for (int j = 1; j <= N; j++) {
			col[rowNo] = j;
			if (checking(rowNo)) {
				setQueens(rowNo + 1);
			}
			//2차원 행렬이 아니라 값 초기화 필요 없음
		}
	}

	// rowNo 행의 퀸을 놓는게 가능한지 체크 : 놓을 수 있다면 true, 없다면 false
	private static boolean checking(int rowNo) {

		for (int i = 1; i < rowNo; i++) {
			// 같은 열인지, 대각선인지 2가지 체크
			//(col[rowNo] == col[i]) 같은 열인지
			//Math.abs(col[rowNo] - col[i]) == rowNo - i 대각선인지 2가지 체크, 대각선 체크는 열값의 차이와 행 값의 차이가 같으면 대각선
			if ((col[rowNo] == col[i]) || Math.abs(col[rowNo] - col[i]) == rowNo - i) {
				return false;
			}
		}
		return true;
	}
}
