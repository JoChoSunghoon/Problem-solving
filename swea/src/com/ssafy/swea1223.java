package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1223 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {

			int n = Integer.parseInt(br.readLine());

			String str = br.readLine();

			int[] num = new int[n / 2 + 1];
			int nidx = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '+' || str.charAt(i) == '*') {
					continue;
				} else {
					num[nidx] = str.charAt(i) - '0';
					if (i > 0 && str.charAt(i - 1) == '*') {
						num[nidx] = num[nidx] * num[nidx - 1];
						num[nidx - 1] = 0;
					}
					nidx++;
				}
			}
			
			int sum = 0;
			for (int i = 0; i < nidx; i++) {
				sum += num[i];
			}

			ans.append("#" + test_case + " " + sum + "\n");
		}
		System.out.println(ans);
	}
}
