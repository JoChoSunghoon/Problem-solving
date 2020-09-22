package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol2857 { // 세로읽기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		char[][] board = new char[5][15];

		String str = "";

		for (int i = 0; i < board.length; i++) {
			str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				board[i][j] = str.charAt(j);
			}
		}

		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				if (board[i][j] != '\u0000') {
					ans.append(board[i][j]);

				}
			}
		}
		System.out.println(ans);
		
		/*
		String[] s = new String[5];
		for (int i = 0; i < s.length; i++) {
			s[i] = br.readLine();
		}
		String result = "";
		for (int col = 0; col < 15; col++) {// 세로
			for (int row = 0; row < s.length; row++) {
				if (s[row].length() > col) {
					result += s[row].charAt(col);
				}
			}
		}
		
		System.out.println(result);
		*/
		
	}
}
