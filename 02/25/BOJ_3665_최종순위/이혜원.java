import java.util.*;
import java.io.*;

/*
 * 메모리 : 60492 KB, 시간 : 508 ms
 * <문제풀이 아이디어>
 * - (1) 작년의 순서 : 만약 5-4-3-2-1 이면, i=5는 (5,4), (5,3), (5,2), (5,1)의 간선을 갖게 됨
 * 				i=4는 (4,3), (4,2), (4,1)
 * 				... (결국 5보다 4, 3, 2, 1은 하위 등수고, 4보다 3, 2, 1은 하위 등수다~ 라는 단방향 간선이 있다고 치는 거)
 * 		=> 작년 순서를 입력 받은 대로 map 배열(간선 저장)를 만들어줌 
 * 
 * - (2) m번 순서가 바뀐다 : 일단 두 숫자(a,b)가 들어오면 입력 순서 상관 없이 a와 b의 위치가 서로 바뀐다고 생각해야 함(무조건 a가 b보다 상위 등수란 게 X)
 * 						 (1)에서 만든 map 배열에서 원래 간선쌍 삭제해주고, 뒤바뀐 간선쌍 추가해줌
 * 							※ 위상정렬할 때 쓰는 각 노드의 입구 개수 저장하는 inDegree 배열도 물론 수정해주어야 함
 * - (3) 위상정렬 ㄱㄱ
 * 		 1) IMPOSSIBLE : 직접 그려보면 아는데... 일관성이 없다는 건 결국 그래프에 순환하는 부분이 생긴다는 거... 그래서 q가 비면 IMPOSSIBLE 처리
 * 		 2) ? : 애초에 바뀐 등수를 모두 제공해주기 때문에 이런 일 안 생김 신경 ㄴㄴ
 */

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스
		StringBuilder sb = new StringBuilder(); // 출력용
		
		Loop1:
		for (int t=0;t<tc;t++) {
			
			int n = Integer.parseInt(br.readLine()); // 팀의 수(노드 수)
			boolean[][] map = new boolean[n+1][n+1]; // map[i][j] = true : i->j 연결됨, false : 연결 X
			
			int[] lastYear = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				lastYear[i] = Integer.parseInt(st.nextToken()); 
			}
			
			int[] inDegree = new int[n+1];
			for (int i=0;i<n;i++) {
				for (int j=i+1;j<n;j++) {
					map[lastYear[i]][lastYear[j]] = true; // i->j 관계 성립
					inDegree[lastYear[j]]++;
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			for (int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				if (map[start][end]) { // 원래 순서 start->end 였을 경우, end->start로 반전
			        map[start][end] = false;
			        map[end][start] = true; // 반전
			        inDegree[end]--;
			        inDegree[start]++;
			    } 
				else { // 원래 순서 end->start 였을 경우, start->end로 반전
			        map[end][start] = false;
			        map[start][end] = true;
			        inDegree[start]--;
			        inDegree[end]++;
			    }
			}
			
			Deque<Integer> q = new ArrayDeque<>(); // 큐
			int[] result = new int[n];
			
			for (int i=1;i<=n;i++) {
				if(inDegree[i]==0) q.offerLast(i);
			}
			
			// 위상 정렬 시작
			for (int i=0;i<n;i++) {
				// 도중에 큐가 비면 정렬 불가능 (순환 고리 생김)
				if(q.isEmpty()) {
					sb.append("IMPOSSIBLE\n");
					continue Loop1; // 정렬 종료
				}
				
				int current = q.pollFirst();
				result[i] = current;
				
				for (int nextPoint=1;nextPoint<=n;nextPoint++) {
					if (map[current][nextPoint]) {
						if (--inDegree[nextPoint]==0) q.addLast(nextPoint);
					}
				}
			}
			
			for (int i=0;i<n;i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

