T = int(input())
for tc in range(1, T+1):
    n = int(input())

    arr = [0] * 101
    lst = list(map(int, input().split()))

    for i in range(len(lst)):
        arr[lst[i]] += 1

    max = 0
    result = 0
    for i, a in enumerate(arr):
        if max <= a:
            max = a
            result = i

    print(f'#{n} {result}')
