def find_parent(parent, x):
    root = x
    while parent[root] != root:
        root = parent[root]  # 최상위 루트까지 이동
    
    while x != root:  # 경로 압축
        parent[x], x = root, parent[x]
    
    return root

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b: parent[b] = a
    else: parent[a] = b

V, E = map(int, input().split())
parent = [i for i in range(V+1)]

edges = []
result = 0

for _ in range(E):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))
edges.sort()

for edge in edges:
    c, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += c

print(result)
