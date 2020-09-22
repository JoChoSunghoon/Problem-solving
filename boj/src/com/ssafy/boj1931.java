package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1931 { // boj 1931 회의실 배정

	private static Conf[] conf;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		conf = new Conf[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			conf[i] = new Conf(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(conf);

		int ans = 0;
		int prev = -1;
		for (int i = 0; i < n; i++) {
			if (conf[i].start >= prev) {
				ans++;
				prev = conf[i].end;
			}
		}
		System.out.println(ans);
	}

	static class Conf implements Comparable<Conf> {
		int start;
		int end;

		public Conf(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Conf o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
}
