package coding;

import java.io.*;
import java.util.*;

public class Solution_3665_최종순위 {
	
	// 자기 보다 순위 가 높은 애들 수를 degree로 카운트
	// degree가 없으면 위상정렬로 순위로 산출 / degree[] = 0 이 중간에 끊기면 "IMPOSSIBLE" / 한번에 degree[] = 0  두개 이상이다? -> "?"
	
	static int N, M ;
	static boolean[][] isCheck;
	static int[] degree;
	static StringBuilder sb;
	static boolean error;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= testCase ; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			degree = new int[N + 1];
			isCheck = new boolean[N + 1][N + 1];
			sb = new StringBuilder();
			error = false;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N ; i++) {
				int rankIndex = Integer.parseInt(st.nextToken());
				
				for(int j = 1; j <= N; j++) {
					
					if(j != rankIndex && !isCheck[j][rankIndex]) {
						isCheck[rankIndex][j] = true;
						degree[j]++;
					}
				}
			}
			
			M = Integer.parseInt(br.readLine());
			for(int i = 0; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				swap(a, b);
			}
			
			sort();
			if (!error) System.out.println(sb);
		}
		
	}
	
	public static void sort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1 ; i <= N; i++) {
			if (degree[i] == 0)
				q.offer(i);
		}
		
		
		for(int i = 0; i < N ; i++) {
			
			if (q.size() == 0) {
				System.out.println("IMPOSSIBLE");
				error = true;
				break;
			}
			
			if (q.size() >= 2) {
				System.out.println("?");
				error = true;
				break;
			}
			
			int rankindex = q.poll();
			sb.append(rankindex).append(" ");
			
			for(int j = 1 ; j <= N ; j++) {
				
				if(isCheck[rankindex][j]) {
					if(--degree[j] == 0)
						q.offer(j);
				}
			}
		}
		
		
	}
	
	
	public static void swap(int a, int b) {
		if(isCheck[a][b]) {
			
			isCheck[a][b] = false;
			isCheck[b][a] = true;
			degree[a]++;
			degree[b]--;
		}
		else {
			isCheck[a][b] = true;
			isCheck[b][a] = false;
			degree[a]--;
			degree[b]++;
		}
	}
}

