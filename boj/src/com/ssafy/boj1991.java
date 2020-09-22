package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1991 { //트리 순회
	
	private static Node[] nd;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		nd = new Node[n];
		for (int i = 0; i < nd.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nd[st.nextToken().charAt(0)-'A'] = new Node(st.nextToken().charAt(0),st.nextToken().charAt(0));
		}
		
		preOrder('A');
		System.out.println();
		inOrder('A');
		System.out.println();
		postOrder('A');
		
	}
	
	private static void preOrder(char now) {
		if(now=='.') {
			return;
		}
		System.out.print(now);
		preOrder(nd[now-'A'].left);
		preOrder(nd[now-'A'].right);
	}
	private static void inOrder(char now) {
		if(now=='.') {
			return;
		}
		inOrder(nd[now-'A'].left);
		System.out.print(now);
		inOrder(nd[now-'A'].right);
	}
	private static void postOrder(char now) {
		if(now=='.') {
			return;
		}
		postOrder(nd[now-'A'].left);
		postOrder(nd[now-'A'].right);
		System.out.print(now);
	}
}

class Node{
	public char left;
	public char right;
	
	public Node(char left, char right) {
		this.left = left;
		this.right = right;
	}
}
