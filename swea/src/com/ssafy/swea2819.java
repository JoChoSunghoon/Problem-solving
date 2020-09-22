package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea2819 { // Solution_SWEA_2819_격자판_조성훈

	private static String[][] arr = new String[4][4];
	private static Set<String> set;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static StringBuilder sb;
	private static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {

			set = new HashSet<String>();

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = st.nextToken();
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					sb = new StringBuilder();
					dfs(i, j, sb.append(""));
				}
			}
			ans.append("#"+test_case+" "+set.size()+"\n");
		}
		System.out.println(ans);
	}

	public static void dfs(int r, int c, StringBuilder s) {
		s.append(arr[r][c]);
		if (s.length() == 7) {
			set.add(s.toString());
		}
		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			if (x >= 0 && x < 4 && y >= 0 && y < 4 && s.length() < 7) {
				dfs(x, y, s);
				s.deleteCharAt(s.length() - 1);
			}
		}
	}
}
