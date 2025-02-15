T = int(input())
for tc in range(1, T+1):

    N = int(input())
    arr = list(map(int, input().split()))
    test = list(map(int, input().split()))

    cnt = 0
    for i in range(N):
		    # 비교해서 다르면 스위치 동작
        if test[i] != arr[i]:
		        # 스위치 눌리기 : 현재위치 부터 끝까지 작동
            for a in range(i+1, N):
		            # 1이면 0, 0이면 1해줌
                test[a] = (test[a]+1) % 2
            
            # 스위치 눌리면 카운트
            cnt += 1

    print(f'#{tc} {cnt}')
