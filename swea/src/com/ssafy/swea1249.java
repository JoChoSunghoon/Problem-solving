package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea1249 { // 보급로
	private static int n;
	private static int[][] arr;
	private static int[][] dp;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {

			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			dp = new int[n][n];

			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[]{0,0,0});
			dp[0][0] = 0;
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j) - '0';
					dp[i][j]=MAX;
				}
			}
			
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				
				for(int i =0;i<4;i++) {
					int row = temp[0]+dx[i];
					int col = temp[1]+dy[i];
					if(row>=0 && row<n&&col>=0&&col<n) {
						int time = temp[2]+ arr[row][col];
						if(dp[row][col]>time) {
							dp[row][col] = time;
							queue.offer(new int[]{row,col,dp[row][col]});
						}
					}
				}
			}
			

			ans.append("#" + test_case + " " + dp[n-1][n-1] + "\n");
		}
		System.out.println(ans);
	}
}
