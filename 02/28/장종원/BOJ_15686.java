import java.io.*;
import java.util.*;

/**
 * 

 * 
 *
 * 메모리 : 16460 KB
 * 시간 : 132 ms
 *
 */

public class Baekjoon15686 {
	
	static int N, M;
	static int[][] map;
	static List<int[]> homeList;
	static List<int[]> chickenList;
	static boolean[] check;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		homeList = new ArrayList<int[]>();
		chickenList = new ArrayList<int[]>();
		check = new boolean[13];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 집 위치
				if(map[i][j] == 1) {
					homeList.add(new int[] {i, j});
				}
				// 치킨 위치
				if(map[i][j] == 2) {
					chickenList.add(new int[] {i, j});
				}
				
			}
		}
		

		
		combi(0, 0);
		System.out.println(result);
	}
	
	public static void combi(int cnt,int idx) {
		
		
		if(cnt == M) {
			disMin();
			return;
		}
		
		if(idx == chickenList.size()) return;
		
		check[idx] = true;
		combi(cnt + 1, idx + 1);
		check[idx] = false;
		combi(cnt, idx + 1);
		
	}
	
	public static void disMin() {
		int sum = 0;
		
		for(int i = 0 ; i < homeList.size(); i++) {
			int distance = Integer.MAX_VALUE;
			for(int j = 0; j <13 ; j++) {
				if(check[j]) {
				int x1 = homeList.get(i)[0];
				int y1 = homeList.get(i)[1];
				int x2 = chickenList.get(j)[0];
				int y2 = chickenList.get(j)[1];
				
				distance = Math.min(distance, Math.abs(x1 - x2) + Math.abs(y1 - y2));
				}
			}
			sum += distance;
		}
		result = Math.min(result, sum);
	}
}
