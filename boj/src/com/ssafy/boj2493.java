package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<int[]> top = new Stack<int[]>();

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (top.isEmpty()) {
				ans.append("0 ");
				top.push(new int[] {num,i});
			} else {
				while (true) {
					if (top.isEmpty()) {
						ans.append("0 ");
						top.push(new int[] {num,i});
						break;
					}
					if (top.peek()[0] > num) {
						ans.append(top.peek()[1]+" ");
						top.push(new int[] {num,i});
						break;
					} else {
						top.pop();
					}
				}
			}
		}
		System.out.println(ans.toString() + "\n");
	}
}
