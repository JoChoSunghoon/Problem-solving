package com.ssafy;

import java.util.Scanner;

public class jungol1161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		hanoi(n,1,2,3);
	}
	private static void hanoi(int n, int from, int mid, int to) {
		if (n == 1) {
			System.out.println(n + " : " + from + " -> " + to);
			return;
		} else {
			hanoi(n - 1, from, to, mid);
			System.out.println(n + " : " + from + " -> " + to);
			hanoi(n - 1, mid, from, to);
		}
	}
}
