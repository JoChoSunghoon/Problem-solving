package com.ssafy;

import java.util.Scanner;

public class jungol1175 { // 주사위 던지기2
	private static int[] ans;
	private static int n;
	private static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		ans = new int[n];
		permutation(0, 0);
	}

	private static void permutation(int cnt, int sum) {
		if (cnt == n) {
			if(sum==m) {
				for(int i=0;i<n;i++) {
					System.out.print(ans[i]+" ");
				}
				System.out.println();
			}
			return;
		} else {
			for (int i = 1; i <= 6; i++) {
				ans[cnt] = i;
				permutation(cnt + 1, sum+ans[cnt]);
			}
		}
	}
}
