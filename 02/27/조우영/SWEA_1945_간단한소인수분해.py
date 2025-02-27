T = int(input())
num = [2, 3, 5, 7, 11]
for tc in range(1, T+1):
    N = int(input())
    arr = [0, 0, 0, 0, 0]

    while N != 1:
        for i in range(len(num)):
            if N % num[i] == 0:
                N = N//num[i]
                arr[i] += 1
    print(f'#{tc}', *arr)
