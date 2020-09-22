package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16235 { // boj16235 나무재테크, 하, 큐와 정렬을 사용한 구현

	private static int n, m, k;
	private static int x, y, year;
	private static int[][] arr;
	private static int[][] brr;
	private static int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0 };
	private static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

	private static PriorityQueue<Tree> list = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		brr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = 5;
				brr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			year = Integer.parseInt(st.nextToken());
			list.offer(new Tree(x, y, year));
		}

		Queue<Tree> die = new LinkedList<>();
		Queue<Tree> child = new LinkedList<>();
		for (int t = 0; t < k; t++) {
			PriorityQueue<Tree> copy = new PriorityQueue<>();

			// 봄
			int len = list.size();
			for (int i = 0; i < len; i++) {
				Tree now = list.poll();
				int nx = now.x;
				int ny = now.y;

				if (arr[nx][ny] < now.year) {
					die.offer(new Tree(nx, ny, now.year));
				} else {
					arr[nx][ny] -= now.year;
					copy.offer(new Tree(nx, ny, now.year + 1));
					if ((now.year + 1) % 5 == 0) {
						child.offer(new Tree(nx, ny, now.year + 1));
					}
				}
			}

			// 여름
			while (!die.isEmpty()) {
				Tree now = die.poll();
				arr[now.x][now.y] += now.year / 2;
			}

			// 가을
			while (!child.isEmpty()) {
				Tree now = child.poll();
				for (int i = 0; i < 8; i++) {
					int x = now.x + dx[i];
					int y = now.y + dy[i];
					if (x >= 0 && x < n && y >= 0 && y < n) {
						copy.offer(new Tree(x, y, 1));
					}
				}
			}

			// 가을
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] += brr[i][j];
				}
			}
			list = new PriorityQueue<Tree>(copy);
		}
		System.out.println(list.size());
	}

	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int year;

		public Tree(int x, int y, int year) {
			this.x = x;
			this.y = y;
			this.year = year;
		}

		@Override
		public int compareTo(Tree o) {
			return this.year - o.year;
		}
	}
}
