# 양방향이므로 역방향 간선 추가
# 1->x->y->N 과 1->y->x->N 두 가지 중 최솟값을 결과로

INF = int(1e9)
N, E = map(int, input().split())

graph = [[INF]*(N+1) for _ in range(N+1)]

for i in range(E):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c  # 역방향

x, y = map(int, input().split())

# 모든 간선 최소 경로 구하기
for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

result = min(graph[1][x] + graph[x][y] + graph[y][N], graph[1][y] + graph[y][x] + graph[x][N])
print(result)
