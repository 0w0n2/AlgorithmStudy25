T = int(input())
for tc in range(1, T+1):

    N = int(input())
    arr = list(map(str, input().split()))

    left = []
    right = []
    result = []

    for i in range(N):
        if i < (N+1)//2:
            left.append(arr[i])
        else:
            right.append(arr[i])

    for i in range(N-1, -1, -1):
        if i % 2 == 0:
            result.append(left.pop())
        else:
            result.append(right.pop())

    result.reverse()
    
    print(f'#{tc}', *result)
