import java.util.*;
import java.io.*;

public class Main {
	
	static int[] par;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine()); // 게이트 수
		int P = Integer.parseInt(br.readLine()); // 비행기의 수
		
		par = new int[G+1];
		for (int i=1;i<=G;i++) {
			par[i] = i; // 자기자신의 부모노드를 자기자신으로 처리
		}
		
		int res = 0;
		for (int i=0;i<P;i++) {
			int g = Integer.parseInt(br.readLine());
			int dockingGate = find(g);
			
			if(dockingGate==0) break; // 더이상 도킹할 곳이 없으면 종료
			
			merge(dockingGate, dockingGate-1); // 현재 도킹한 케이트를 '없어진 것'처럼 처리 (최종적으로 g-1은 0까지 감)
			res++;
		}
		System.out.print(res);
		
	}
	
	static int find(int x) {
		if (par[x]==x) return x; 
		return par[x] = find(par[x]);
	} 
	
	static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		par[a] = b;
	}
	
}
