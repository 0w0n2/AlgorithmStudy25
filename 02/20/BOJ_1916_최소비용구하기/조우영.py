import heapq

INT = int(1e9)
N = int(input())
M = int(input())

# 그래프는 1부터 N+1까지
graph = [[] for _ in range(N+1)]
distance = [INT] * (N+1)

# 그래프 생성
for i in range(M):
    a, b, c = map(int, input().split())  # b:노드(도착), c:비용
    graph[a].append((b, c))

start, end = map(int, input().split())

def dijkstra(start, end):
    q = []
    heapq.heappush(q, (start, 0))  # 시작점 넣고
    distance[start] = 0

    while q:
        node, cost = heapq.heappop(q)  # 빼서 인접 노드 탐색
        if distance[node] < cost: continue  # 꺼낸 값이 기록된보다 크다면 처리, 노드 무시
        
        for i in graph[node]:  # 인접 노드 탐색 [0]:노드, [1]:비용
            new_cost = cost + i[1]  # 뺀 노드에서 비용 더해줌(최소거리)
            if new_cost < distance[i[0]]:  # 작은거 발견, 갱신해줌
                distance[i[0]] = new_cost
                heapq.heappush(q, (i[0], new_cost))
    return distance[end]

print(dijkstra(start, end))
