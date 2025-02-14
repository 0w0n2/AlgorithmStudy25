T = int(input())
for tc in range(1, T+1):

    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    for _ in range(M):
        i, j = map(int, input().split())
        b = i-1     # 2번째면 1번째부터
        for a in range(1, j+1):
            # 범위 밖이면 종료
            if b-a < 0 or b+a >= N: break

            if arr[b-a] == arr[b+a]:
                if arr[b-a] == 0:
                    arr[b-a] = arr[b+a] = 1
                else:
                    arr[b-a] = arr[b+a] = 0

    print(f'#{tc} {" ".join(map(str, arr))}')
