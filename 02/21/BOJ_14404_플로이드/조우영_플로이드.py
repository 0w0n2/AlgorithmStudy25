INF = int(1e9)
n = int(input())
m = int(input())

graph = [[INF]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, n+1):
        if i==j:
            graph[i][j] = 0

for _ in range(m):
    a, b, c = map(int, input().split())
    # a에서 b까지 여러개일수도 있으므로 최솟값을 미리 받아준다
    graph[a][b] = min(c, graph[a][b])

# 플로이드 워셜 점화식
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == INF: print(0, end=' ')
        else: print(graph[i][j], end=' ')
    print()
