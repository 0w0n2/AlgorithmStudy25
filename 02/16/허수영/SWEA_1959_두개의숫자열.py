T=int(input())
for _ in range(1,T+1):
    N,M=map(int,input().split())
    A=list(map(int,input().split()))
    B=list(map(int,input().split()))

    result=0
    if N<M:
        for i in range(M-N+1):
            sum = 0
            for j in range(N):
                sum+=A[j]*B[i+j]
            result=max(result,sum)
    else:
        for i in range(N-M+1):
            sum=0
            for j in range(M):
                sum+=A[i+j]*B[j]
            result=max(result,sum)
    print(f'#{_} {result}')
