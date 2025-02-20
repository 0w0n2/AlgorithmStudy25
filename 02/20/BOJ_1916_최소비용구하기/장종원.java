package offline;

import java.util.*;
import java.io.*;

public class Solution_1916최소비용 {
    static int N, M;
    static List<List<Node>> graph;
    static int[] cost;
    static boolean[] check;
    static PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2)-> e1.weight -e2.weight);
    
    static class Node{
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        cost = new int[N + 1];
        check = new boolean[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(cost[end]);
    }

    public static void dijkstra(int start) {
        pq.offer(new Node(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.node;

            if (check[cur]) continue;
            check[cur] = true;

            for (Node node : graph.get(cur)) {
                if (!check[node.node] && cost[node.node] > cost[cur] + node.weight) {
                    cost[node.node] = cost[cur] + node.weight;
                    pq.add(new Node(node.node, cost[node.node]));
                }
            }
        }
    }
}



