package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol2514 { // 문자열 찾기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String k = "KOI";
		String i = "IOI";
		
		int knum=0;
		int inum=0;
		//indexOf로도 가능
		
		for(int j=0;j<str.length()-2;j++) {
			if(k.equals(str.substring(j,j+3))){
				knum++;
			}
			if(i.equals(str.substring(j,j+3))){
				inum++;
			}
		}
		System.out.println(knum);
		System.out.println(inum);
	}
}
