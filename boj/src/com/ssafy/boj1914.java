package com.ssafy;

import java.math.BigInteger;
import java.util.Scanner;

public class boj1914 { // boj1914 하노이 Silver2 중 BigInteger 사용문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		BigInteger k = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
		System.out.println(k);
		
		if (n <= 20) {
			hanoi(n, 1, 2, 3);
		}
	}

	static void hanoi(int n, int from, int mid, int to) {
		if (n == 1) {
			System.out.println(from + " " + to);
			return;
		}
		hanoi(n - 1, from, to, mid);
		System.out.println(from + " " + to);
		hanoi(n - 1, mid, from, to);
	}
}