dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

T = int(input())
for tc in range(1, T+1):

    N = int(input())

    arr = []
    for i in range(N):
        arr.append(list(map(int, input().split())))
    
    max_v = 0
    min_v = 10000
    for i in range(N):
        for j in range(N):
            sum = 0
            for a in range(4):
                for k in range(1, N+1):
                    nx = i + dx[a]*k
                    ny = j + dy[a]*k
                    if nx<0 or ny<0 or nx>=N or ny>=N: continue
                    sum += arr[nx][ny]
            sum += arr[i][j]
            max_v = max(max_v, sum)
            min_v = min(min_v, sum)
    
    print(f'#{tc} {max_v-min_v}')
