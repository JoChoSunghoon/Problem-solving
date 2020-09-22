package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 { // boj1753 최단 경로 gold5
	private static int v, e;
	private static List<List<Node>> list;
	private static int[] dist;
	private static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		list = new ArrayList<List<Node>>();
		dist = new int[v];
		visit = new boolean[v];

		for (int i = 0; i < v; i++) {
			list.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}

		int start = Integer.parseInt(br.readLine()) - 1;

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, weight));
		}

		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		int current;

		while (!pq.isEmpty()) {
			current = pq.poll().no;

			if (visit[current]) {
				continue;
			}
			visit[current] = true;

			for (Node node : list.get(current)) {
				if (dist[node.no] > dist[current] + node.dist) {
					dist[node.no] = dist[current] + node.dist;
					pq.offer(new Node(node.no, dist[node.no]));
				}
			}

		}

		for (int i = 0; i < v; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}

	static class Node implements Comparable<Node> {
		int no;
		int dist;

		public Node(int no, int dist) {
			super();
			this.no = no;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
}
