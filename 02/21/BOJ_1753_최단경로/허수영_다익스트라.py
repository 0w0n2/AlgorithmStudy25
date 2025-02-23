import heapq
import sys
input=sys.stdin.readline

v,e=map(int,input().strip().split())
k=int(input().strip())
arr=[[] for _ in range(v+1)]
INF=int(1e9)

for _ in range(e):
    u,v,w=map(int,input().split())
    arr[u].append((v,w))

distance = [INF]*(v+1)
distance[k]=0

pq=[]
heapq.heappush(pq,(0,k))

while pq:
    smalldis,now = heapq.heappop(pq)

    if distance[now]<smalldis:
        continue

    for next,weight in arr[now]:
        cost=smalldis+weight
        if cost<distance[next]:
            distance[next]=cost
            heapq.heappush(pq, (cost,next))

for i in range(1,v+1):
    if distance[i]==INF:
        print('INF')
    else:
        print(distance[i])
