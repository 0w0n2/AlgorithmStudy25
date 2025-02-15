T = int(input())
for tc in range(1, T+1):

    N, M = map(int, input().split())
    puzzle = []
    for i in range(N):
        puzzle.append(list(map(int, input().split())))

    result = 0

    # 1이 나오면 카운트
    # 중간에 0이 나오거나 마지막에 도달하면 카운트를 세어준다
    # 카운트가 M개이면 가능갯수 1개 늘리기, 그리고 카운트 초기화

    # 행 순회
    for i in range(N):
        cnt = 0
        for j in range(N):
            if puzzle[i][j]:
                cnt += 1

            if puzzle[i][j] == 0 or j == N - 1:
                if cnt == M:
                    result += 1
                cnt = 0

    # 열 순회
    for i in range(N):
        cnt = 0
        for j in range(N):
            if puzzle[j][i]:
                cnt += 1

            if puzzle[j][i] == 0 or j == N - 1:
                if cnt == M:
                    result += 1
                cnt = 0

    print(f'#{tc} {result}')
