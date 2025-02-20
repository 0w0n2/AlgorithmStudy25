T = int(input())
for tc in range(1, T+1):

    N, M = map(int, input().split())

    arr = []
    for i in range(N):
        arr.append(list(map(int, input().split())))

    result = 0
    for i in range(N):
        for j in range(N):
            sum_v = 0
            for a in range(i, i+M):
                for b in range(j, j+M):
                    if a >= N or b >= N: continue
                    sum_v += arr[a][b]
            result = max(result, sum_v)

    print(f'#{tc} {result}')
