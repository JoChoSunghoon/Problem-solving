package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2263 { // boj 2263 트리의 순회 gold3 상 배열의 인덱스 관리가 어려웠음
	private static int n;
	private static int[] inOrder;
	private static int[] postOrder;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		inOrder = new int[n + 1];
		postOrder = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int order = Integer.parseInt(st.nextToken());
			inOrder[order] = i; //postOrder의 마지막 값이 루트인 점을 이용하여 inOrder에서 루트를 기준으로 좌우 배열을 나누어 관리하기 위해 inOrder는 순서를 관리
		}
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}

		preOrder(0, n - 1, 0, n - 1);
	}

	public static void preOrder(int is, int ie, int ps, int pe) {
		if (is > ie || ps > pe) {
			return;
		}
		int root = postOrder[pe];
		System.out.print(root + " ");
		preOrder(is, inOrder[root] - 1, ps, inOrder[root] - 1 + ps -is);
		preOrder(inOrder[root] + 1, ie, inOrder[root] + ps - is, pe - 1);
	}
}
