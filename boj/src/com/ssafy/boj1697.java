package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 { //숨바꼭질
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();

		int[] check = new int[100001];

		if (n == k) {
			System.out.println("0");
			return;
		}

		check[n] = 0;
		q.offer(n);

		while (!q.isEmpty()) {
			int now = q.poll();
			if (check[k] > 0) {
				break;
			}
			if (now - 1 >= 0 && check[now - 1] == 0) {
				q.offer(now - 1);
				check[now - 1] = check[now] + 1;
			}
			if (now + 1 < check.length && check[now + 1] == 0) {
				q.offer(now + 1);
				check[now + 1] = check[now] + 1;
			}
			if (now * 2 < check.length && check[now * 2] == 0) {
				q.offer(now * 2);
				check[now * 2] = check[now] + 1;
			}
		}

		System.out.println(check[k]);
	}
}
