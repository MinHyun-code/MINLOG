package jpa.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];

		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			arr[i] += arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int sum = arr[num2] - arr[num1-1];
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}