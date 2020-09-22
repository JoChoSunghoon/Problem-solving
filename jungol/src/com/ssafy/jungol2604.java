package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol2604 { // 그릇
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		char prev = str.charAt(0);

		int sum = 10;
		for (int i = 1; i < str.length(); i++) {
			if (prev != str.charAt(i)) {
				sum += 10;
				prev = str.charAt(i);
			} else {
				sum+=5;
			}
		}
		System.out.println(sum);
	}
}
