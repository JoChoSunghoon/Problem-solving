package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1861 { // 정사각형 방
	private static int[][] arr;
	private static boolean[][] check;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			check = new boolean[n][n];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					check[i][j] = false;
				}
			}

			int ans = n * n;
			int ansCnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j]) { // 지나온 곳이면 패스
						continue;
					} else {
						int x = i;
						int y = j;
						while (true) { //연결된 수중 제일 작은 곳으로 이동
							boolean tempCheck = false;
							for (int k = 0; k < 4; k++) {
								int row = x + dx[k];
								int col = y + dy[k];
								if (row >= 0 && row < n && col >= 0 && col < n) {
									if (arr[x][y] == arr[row][col] + 1) {
										x = row;
										y = col;
										tempCheck = true;
										break;
									}
								}
							}
							if (!tempCheck) {
								break;
							}
						}
						check[x][y] = true;

						int tempAns = arr[x][y]; //제일 작은 곳 저장
						int tempCnt = 1;
						while (true) { //연결된 수로 계속 이동
							boolean tempCheck = false;
							for (int k = 0; k < 4; k++) {
								int row = x + dx[k];
								int col = y + dy[k];
								if (row >= 0 && row < n && col >= 0 && col < n) {
									if (arr[x][y] + 1 == arr[row][col]) {
										x = row;
										y = col;
										check[x][y] = true;
										tempCheck = true;
										tempCnt++;
										break;
									}
								}
							}
							if (!tempCheck) {
								break;
							}
						}
						//값 비교 후 업데이트
						if (tempCnt == ansCnt) {
							if (tempAns < ans) {
								ansCnt = tempCnt;
								ans = tempAns;

							}
						} else if (tempCnt > ansCnt) {
							ansCnt = tempCnt;
							ans = tempAns;
						}
					}
				}
			}

			answer.append("#" + test_case + " " + ans + " " + ansCnt + "\n");
		}
		System.out.println(answer);

	}// end of main
}// end of class





//입력된 숫자를 index로 하는 2차원 배열 >> 저장 값은 각각의 row,col 정보 이것을 1바퀴 순회하면서 출력
//이것보다 빠르게 하려면 dp 사용에 + 입력에 관한 클래스 정의 후 사용