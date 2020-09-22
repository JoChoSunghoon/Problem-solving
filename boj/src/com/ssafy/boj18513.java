package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class boj18513 { // boj18513 샘터 gold5 중상 접근 방법을 잘못함
	private static int n; // 치킨집의 수
	private static int k; // 집의 수
	// 일직선 공간의 범위가 [-1억,1억]이므로 넉넉하게 정답을 long타입 변수로 설정
	private static long ans = 0;
	private static int[] d = { -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()); // 치킨집 수 저장
		k = Integer.parseInt(st.nextToken()); // 집의 수 저장

		Queue<int[]> q = new LinkedList<>();
		Set<Integer> s = new HashSet<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken()); // 치킨집 위치 저장, 배열의 인덱스로 사용하기 위해 1억을 더해 음수를 제거해줌
			q.offer(new int[] { num, num });
			s.add(num);
		}

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] now = q.poll();

				for (int j = 0; j < 2; j++) {
					int x = now[0] + d[j];
					if (x < -100000000 || x > 100000000 || s.contains(x)) {
						continue;
					}
					
					k--;

					ans += Math.abs(x - now[1]);

					if (k == 0) {
						System.out.println(ans);
						System.exit(0);
					}

					s.add(x);
					q.offer(new int[] { x, now[1] });
				}
			}
		}

		System.out.println(ans); // 정답 출력

	} // end of main

} // end of class
