import heapq
import sys
input=sys.stdin.readline

v,e=map(int,input().split())
# 모든 노드에 대한 진입차수는 0으로 초기화
indegree=[0] * (v+1)
#각 노드에 연결된 간선 정보담기
graph = [[] for _ in range(v+1)]

for _ in range(e):
    a,b=map(int,input().split())
    graph[a].append(b)
    indegree[b]+=1

def topology_sort():
    result=[] #알고리즘 수행결과 리스트
    # q=deque()
    q=[]
    for i in range(1,v+1):
        if indegree[i]==0: #처음시작할때 진입차수 0인 노드를 큐에 삽입
            heapq.heappush(q,i)

    while q:
        now = heapq.heappop(q)
        result.append(now)
        #해당원소와 연결된 놈들 진입차수에서 1뺴기
        for i in graph[now]:
            indegree[i] -=1

            if indegree[i]==0:
                heapq.heappush(q,i)

    for i in result:
        print(i,end=' ')
topology_sort()
