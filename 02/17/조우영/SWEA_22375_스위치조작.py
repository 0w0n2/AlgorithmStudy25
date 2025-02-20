T = int(input())
for _ in range(1,T+1):
    N = int(input())
    Ai = list(map(int, input().split()))
    Bi = list(map(int, input().split()))

    cnt=0
    for i in range(N):
        if Ai[i] != Bi[i]:
            cnt += 1
            for j in range(i,N):
                Ai[j] = 1-Ai[j]

    print(f'#{_} {cnt}')
