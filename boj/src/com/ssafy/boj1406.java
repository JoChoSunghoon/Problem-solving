package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class boj1406 { //에디터
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
//		ArrayList<Character> list = new ArrayList<>();
		LinkedList<Character> list = new LinkedList<>();
		ListIterator<Character> iter = list.listIterator(); // 순차적으로 접근

		int len = str.length();
		for (int i = 0; i < len; i++) {
			iter.add(str.charAt(i));
		}

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			char input = st.charAt(0);

			switch (input) {
			case 'L':
				if (iter.hasPrevious())
					iter.previous();
				break;
			case 'D':
				if (iter.hasNext())
					iter.next();
				break;
			case 'B':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P':
				iter.add(st.charAt(2));
				break;
			default:
				break;
			}
		}
		for (char c : list) {
			System.out.print(c);
		}
	}
}
