import heapq

INF = int(1e9)

V, E = map(int, input().split())
K = int(input())

graph = [[] for _ in range(V+1)]
distance = [INF] * (V+1)

for i in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        cost, node = heapq.heappop(q)
        if distance[node] < cost: continue  # 비용보다 작으면 지나간 노드라고 생각

        for i in graph[node]:   # 해당노드의 인접 리스트 검사
            new_cost = cost + i[1]      # 인접리스트의 다음 거리까지의 합
            if new_cost < distance[i[0]]:     # 인접리스트의 거리보다 작다면 갱신
                distance[i[0]] = new_cost
            heapq.heappush(q, (new_cost, i[0]))    # 검사끝나면 넣어주기

dijkstra(K)

for i in range(1,len(distance)):
    if distance[i] == INF:
        print('INF')
    else: print(distance[i])
