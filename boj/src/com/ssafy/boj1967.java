package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1967 { // 트리의 지름
	private static ArrayList<Node>[] list;
	private static boolean[] visit;
	private static int dist;
	private static int farNode;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[10001];
		visit = new boolean[10001];

		for (int i = 1; i < 10001; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, cost));
			list[b].add(new Node(a, cost));
		}

		dfs(1, 0);

		dist = 0;

		Arrays.fill(visit, false);

		dfs(farNode, 0);

		System.out.println(dist);
	}

	private static void dfs(int node, int cost) {
		if (visit[node]) {
			return;
		}

		visit[node] = true;

		if (dist < cost) {
			dist = cost;
			farNode = node;
		}

		for (Node next : list[node]) {
			dfs(next.n, cost + next.weight);
		}
	}

	static class Node {
		private int n;
		private int weight;

		public Node(int n, int weight) {
			this.n = n;
			this.weight = weight;
		}
	}
}
