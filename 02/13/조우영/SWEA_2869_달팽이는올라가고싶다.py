A, B, V = map(int, input().split())

k = (V-B)/(A-B)
print(int(k) if k==int(k) else int(k)+1)

# V-B : 올라가야할 거리
# A-B : 내려가는 거리
