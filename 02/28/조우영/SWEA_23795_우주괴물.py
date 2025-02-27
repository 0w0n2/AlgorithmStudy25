dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    for i in range(N):
        for j in range(N):
            for a in range(4):
                if arr[i][j] == 2: # 폭탄 위치
                    for K in range(1, 6):  # 리스트보다 큰 범위
                        nx = i + dx[a]*K
                        ny = j + dy[a]*K
                        if nx < 0 or nx >= N or ny < 0 or ny >= N: continue
                        if arr[nx][ny] == 1: break
                        if arr[nx][ny] == 0:
                            arr[nx][ny] = 3  # 터진위치 3으로 표시

    cnt = 0
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 0:
                cnt += 1
    print(f'#{tc} {cnt}')
