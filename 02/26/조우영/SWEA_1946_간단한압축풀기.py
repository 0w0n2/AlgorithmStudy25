T = int(input())
for tc in range(1, T+1):
    N = int(input())

    arr = []
    # 배열에 순서대로 모두 담기
    for _ in range(N):
        alpa, num = input().split()
        for _ in range(int(num)):
            arr.append(alpa)

    i = 0
    print(f'#{tc}')
    while i<len(arr):  # 종료조건을 주는게 좋다
        result = ''  # 10줄마다 초기화
        result += ''.join(arr[i:i+10])  # 슬라이싱으로 문자열 자르기
        i+=10
        print(result)
