T=int(input())
for _ in range(1,T+1):
    N,M=map(int,input().split())
    arr=list(map(int,input().split()))
    for i in range(M):
        a,b=map(int,input().split())
        a -=1 #인덱스 조절위해서 1빼줌
        for j in range(1,b+1):
            if a-j <0 or a+j>=N:  #범위 넘어가면 안됨
                break
            if arr[a-j] == arr[a+j]:  ##반복문돌려서 j만큼 양옆 비교해서
                arr[a-j] = 1-arr[a-j] #같으면 뒤집어버림
                arr[a+j] = 1-arr[a+j]
    print(f'#{_}',*arr)

