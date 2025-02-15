package test1;

import java.io.*;
import java.util.*;

public class Solution_sw_1767_프로세서연결하기 {
	
	// 코드 진행 과정
	// core 위치가 담긴 coreList를 통해 dfs로 완탐.
	// dfs에서 해당 코어가 전기에 흐르는 곳에 갈 수 있는지 메서드
	// 해당 코에 전선을 연결하고 해제(백트레킹)하는 메서드 사용
	
	static int N, core, result, count;
	static int[][] map;
	static ArrayList<int[]> coreList;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= testCase ; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 1 && i != 0 && i != N-1 && j != 0 && j != N-1) coreList.add(new int[] {i, j});
				}
			}
			
			core = 0;
			result = 144;
			
			// dfs
			dfs(0, 0, 0);
			System.out.printf("#%d %d\n", t, result);
		}
	}
	
	// dfs
	public static void dfs(int depth, int c, int line) {
		
		// 모든 코어를 확인했을때
		if(depth == coreList.size()) {
			if(core < c) {
				core = c;
				result = line;
			} else if (core == c) {
				result = Math.min(result, line);
			}
			return;
		}
		
		// 한 코어에 대해 사방 탐색
		for(int dir = 0; dir < 4; dir++) {
			// 해당 방향에 코어가 연결될 수 있는지
			if(isConnet(coreList.get(depth), dir)) {
				fill(coreList.get(depth), dir, 2); // 연결될 수 있는 방향에 노선 설치
				dfs(depth + 1, c + 1, line + count); // dfs
				fill(coreList.get(depth), dir, 0); // 해당 노선을 지워서 백트레킹
			}
		}
		
		dfs(depth + 1, c, line);	//depth 번째 코어를 설치하지 않는 것
	}
	
	// 연결 되는지 메서드
	public static boolean isConnet(int[] list, int dir) {
		
		int x = list[0] + dx[dir];
		int y = list[1] + dy[dir];
		
		while(x >= 0 && y >= 0 && x < N && y < N) {
			if(map[x][y] != 0) return false;
			
			x += dx[dir];
			y += dy[dir];
		}
		return true;
	}
	
	// 노선 연결 설치 메서드
	public static void fill(int[] list, int dir, int value) {
		count = 0;
		int x = list[0] + dx[dir];
		int y = list[1] + dy[dir];
		while(x >= 0 && y >= 0 && x < N && y < N) {
			map[x][y] = value;
			count++;
			x += dx[dir];
			y += dy[dir];
			
		}
	}
}

