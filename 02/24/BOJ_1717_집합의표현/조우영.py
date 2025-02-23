# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 합치는 함수
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b: parent[b] = a
    else: parent[a] = b

V, E = map(int, input().split())
parent = [i for i in range(V+1)]

# 0일때는 합치기, 1일때는 탐색
for i in range(E):
    a, b, c = map(int, input().split())
    if a == 0: union_parent(parent, b, c)
    else:
        # 부모가 같은지 확인
        if find_parent(parent, b) == find_parent(parent, c):
            print('YES')
        else: print('NO')
