package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {

			int n = Integer.parseInt(br.readLine());

			int sum = 0;

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					if (i + j >= n / 2 && j - i <= n / 2 && i + j <= (n - 1) + n / 2 && i - j <= n / 2) {
						sum += str.charAt(j)-'0';
					}
				}
			}
			ans.append("#" + test_case + " " + sum + "\n");
		} // end of test_case
		System.out.println(ans);
	}//end of main
}//end of class
