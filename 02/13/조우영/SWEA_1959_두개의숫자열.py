T = int(input())
for tc in range(1, T+1):

    N, M = map(int, input().split())

    arr1 = list(map(int, input().split()))
    arr2 = list(map(int, input().split()))

    # 로직 시작
    def calculate(arr1, arr2):
        result = 0
        while len(arr2) <= len(arr1):
            sum = 0
            for j in range(len(arr1)):
                if j<len(arr2):
                    sum += arr1[j]*arr2[j]
            result = max(result, sum)
            arr2.insert(0,0)
        return result

    if len(arr1) > len(arr2):
        print(f'#{tc} {calculate(arr1, arr2)}')
    else:
        print(f'#{tc} {calculate(arr2, arr1)}')
