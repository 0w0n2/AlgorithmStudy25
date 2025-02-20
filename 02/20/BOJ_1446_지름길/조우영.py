import heapq

INF = int(1e9)
N, M = map(int, input().split())

graph = [[] for _ in range(M+1)]
distance = [INF] * (M+1)

for i in range(N):
    a, b, c = map(int, input().split())
    if b<=M:
        graph[a].append((b, c))

for i in range(M):
    if i + 1 <= M:
        graph[i].append((i+1, 1))

def dijkstra(start, end):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        cost, node = heapq.heappop(q)
        if distance[node] < cost: continue  # 방문했으면 패스
        for i in graph[node]:  # 인접노드 탐색
            new_cost = cost + i[1]
            if new_cost < distance[i[0]]:
                distance[i[0]] = new_cost
                heapq.heappush(q, (new_cost, i[0]))
    return distance[end]

print(dijkstra(0, M))
print(distance)

