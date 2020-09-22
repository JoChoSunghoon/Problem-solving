package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1493 { // boj1493 박스채우기 gold5
	private static int length, width, height;
	private static int n;
	private static int[] cube = new int[20];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		length = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		long ans = 0;
		long prev = 0;

		for (int i = 19; i >= 0; i--) {
			prev *= 8;

			long cubeCnt = (long) (length >> i) * (width >> i) * (height >> i) - prev; // 현재 박스를 현재 큐브로 채울 수 있는 개수에서
																						// 이전거를 제외
			long cubePos = Math.min((long) cube[i], cubeCnt); // 빼야하는거랑 갖고 있는거를 비교

			prev += cubePos;
			ans += cubePos;
		}

		if (prev != (long) length * width * height) {
			ans = -1;
		}
		System.out.println(ans);
	}
}
