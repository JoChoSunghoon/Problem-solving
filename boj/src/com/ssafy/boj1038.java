package com.ssafy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj1038 { // boj1038 감소하는 수 gold5 중, 부분집합 후 정렬
	private static int n;
	private static int cnt;
	private static int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private static boolean[] visit = new boolean[10];
	private static List<Long> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		subset(0);

		Collections.sort(list);

		if (n >= 1023) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(n + 1));
		}
	}

	public static void subset(int idx) {
		if (idx >= 10) { // 원하는 크기를 넘어가면 종료
			long now = 0;
			for (int i = 9; i >= 0; i--) {
				if (visit[i]) { // 부분집합에서 선택된 경우, 여기서는 큰 수이므로 감소하는 반복문 사용
					now *= 10;
					now += i;
				}
			}
			list.add(now);
			return;
		}

		visit[idx] = false; // 시작은 사용안하는 것으로
		subset(idx + 1); // 재귀
		visit[idx] = true; // 그다음은 방문하는 것으로
		subset(idx + 1); // 재귀
	}
}
