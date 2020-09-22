package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15686 { // boj 15686 치킨배달
	private static int n;
	private static int m;
	private static int ans = Integer.MAX_VALUE;
	private static int[][] arr;
	private static boolean[] check = new boolean[13];
	private static int[] chickIdx = new int[13];
	private static ArrayList<int[]> chick = new ArrayList<int[]>();
	private static ArrayList<int[]> human = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) { // 1이면 사람집 리스트에 추가
					human.add(new int[] { i, j });
				} else if (arr[i][j] == 2) { // 2명 치킨집 리스트에 추가
					chick.add(new int[] { i, j });
				}

			}
		}

		// 치킨집 조합, 백트랙킹 사용
		for(int i=0;i<n;i++) {
			check[i]=true;
			reduceChicken(i, 0);
			check[i]=false;
		}
		
		System.out.println(ans);
	}

	private static void reduceChicken(int now, int cnt) { // i는 현재 치킨집의 인덱스, cnt는 현재까지 조합한 치킨집의 수
		chickIdx[cnt] = now;
		
		if (cnt == m - 1) {// 치킨집 조합 끝
			int sum = 0;
			for (int[] a : human) { // 그 사람 집에서
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < m; j++) { // 치킨집까지의 최소거리
					int[] b= chick.get(chickIdx[j]);
					temp = Math.min(temp, Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]));
				}
				sum += temp;
			}
			ans = Math.min(ans, sum);
		}

		for (int i = now; i < chick.size(); i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			reduceChicken(i, cnt + 1);
			check[i] = false;
		}

	}

}
