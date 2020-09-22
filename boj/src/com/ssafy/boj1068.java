package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1068 {

	private static ArrayList<Integer>[] list;
	private static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] tr = new int[n + 1];
		boolean[] check = new boolean[n + 1];

		list = new ArrayList[n + 1];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		int root = 0;
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			tr[i] = parent; // -1:이면 루트
		}

		for (int i = 0; i < n; i++) {
			int parent = tr[i];
			if (parent == -1) {
				root = i;
				continue;
			}
			list[parent].add(i);
			list[i].add(parent);
		}

		int erase = Integer.parseInt(br.readLine());
		System.out.println(Arrays.toString(check));
		System.out.println(Arrays.toString(tr));
		System.out.println("\n---------------------------\n");
		bfs(tr, check, erase); // 지워야할 노드부터 아래로 검색>> 즉 한번 탐색한 표시
		System.out.println(Arrays.toString(check));
		System.out.println(Arrays.toString(tr));

		System.out.println("\n---------------------------\n");
		cnt = 0;
		bfs(tr, check, root);
		System.out.println(Arrays.toString(check));
		System.out.println(Arrays.toString(tr));
		System.out.println("\n---------------------------\n");

		System.out.println(cnt);
	}// end of main

	private static void bfs(int[] tr, boolean[] check, int node) {
		Queue<Integer> q = new LinkedList<>();
        
        if(check[node]) {
			return;
		}
        
        q.offer(node);
		check[node] = true;

		while (!q.isEmpty()) {
			node = q.poll();
			boolean isLeaf = false;

			for (int i : list[node]) {
				if (!check[i] && tr[node]!= i) {
					check[i] = true;
					q.add(i);
					isLeaf = true;
				}
			}
			if (!isLeaf) {
				cnt++;
			}
		}
	}// end of bfs
}// end of class
