package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String T = br.readLine();
		String P = br.readLine();
		List<Integer> list = new ArrayList<>();

		int[] fail = new int[P.length()];

		for (int i = 0; i < fail.length; i++) {
			fail[i] = 0;
		}

		for (int i = 1, j = 0; i < fail.length; i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = fail[j - 1];
			}
			if (P.charAt(i) == P.charAt(j)) {
				fail[i] = ++j;
			}
		}

		for (int i = 0, j = 0; i < T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = fail[j - 1];
			}
			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					list.add(i - P.length() + 2);
					j = fail[j];
				} else {
					++j;
				}
			}
		}
		
		System.out.println(list.size());
		for(int i : list) {
			System.out.println(i);
		}
	}
}
