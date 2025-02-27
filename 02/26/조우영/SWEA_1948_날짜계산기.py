T = int(input())
arr = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
for tc in range(1, T+1):
    a,b,c,d=map(int,input().split())
    cnt = 0

		# 첫 달
    cnt += arr[a]-b+1
    # 중간 달
    while a+1 < c:
        a += 1
        cnt += arr[a]
    # 막 달
    cnt += d

    if a==c: # 같은 달의 경우
        cnt = d-b+1

    print(f'#{tc} {cnt}')
