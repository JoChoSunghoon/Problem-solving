package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class boj1759 { //boj1759 암호 만들기 gold5 중 정렬 후 조합하고 조건에 맞게 출력
	private static int l, c;
	private static char[] arr;
	private static char[] vowel = { 'a', 'e', 'i', 'o', 'u' };
	private static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		l = sc.nextInt();
		c = sc.nextInt();

		arr = new char[c];
		visit = new boolean[c];

		for (int i = 0; i < c; i++) {
			arr[i] = sc.next().trim().charAt(0);
		}

		Arrays.sort(arr);

		comb(0, c, l, 0);

	}

	private static void comb(int start, int n, int r, int cnt) {
		if (r == 0 && cnt >= 1 && l - cnt >= 2) {
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			visit[i] = true;
			int temp = 0;
			for (int j = 0; j < 5; j++) {
				if (arr[i] == vowel[j]) {
					temp = 1;
					break;
				}
			}
			comb(i + 1, n, r - 1, cnt + temp);
			visit[i] = false;
		}
	}
}
