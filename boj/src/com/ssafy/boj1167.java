package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1167 { // boj1167 트리의 지름
	private static ArrayList<Node>[] list;
	private static boolean[] check;

	private static int dist, farNode;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int v = Integer.parseInt(br.readLine());

		list = new ArrayList[v + 1];
		check = new boolean[v + 1];
		for (int i = 0; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		int root = 1;

		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int cnt = 0;
			while (true) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1) {
					break;
				}
				int c = Integer.parseInt(st.nextToken());
				cnt++;
				list[a].add(new Node(b, c));
			}
			if (cnt == 1) {
				root = a;
			}
		}
		
		dfs(root,0);
		
		Arrays.fill(check,false);
		
		dfs(farNode,0);
		
		System.out.println(dist);

	}

	private static void dfs(int node, int cost) {
		if (check[node]) {
			return;
		}
		check[node] = true;

		if (dist < cost) {
			dist = cost;
			farNode = node;
		}

		for (Node nd : list[node]) {
			dfs(nd.n, nd.weight+cost);
		}
	}

	static class Node {
		int n;
		int weight;

		public Node(int n, int weight) {
			this.n = n;
			this.weight = weight;
		}
	}
}
