package com.ssafy;

import java.util.Scanner;

public class jungol1309 { // 팩토리얼
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n));
	}

	private static long factorial(int i) {
		if (i == 0) {
			System.out.println("0! = 1");
			return 1;
		} else if (i == 1) {
			System.out.println("1! = 1");
			return 1;
		} else {
			System.out.println(i + "! = " + i + " * " + (i - 1) + "!");
			return i * factorial(i - 1);
		}
	}
}
