N = int(input())

for _ in range(N):
    S = list(input())
    N = int(input())
    lst = list(map(int, input().split()))

		# 나머지 값과 슬라이싱으로 최적화
    for i in lst:
        X = abs(i)%len(S)
        if i > 0:
            S = S[X:] + S[0:X]
        elif i < 0:
            S = S[-X:] + S[:-X]

		# 시간초과 (lst로 받는 정수의 값은 -10^9 ~ 10^9 라서 오래걸림)
    # for X in lst:
    #     if X > 0:
    #         for _ in range(X):
    #             S.reverse()
    #             a = list(S.pop())
    #             S = a + S
    #             S. reverse()
    #     elif X < 0:
    #         for _ in range(-X):
    #             a = list(S.pop())
    #             S = a + S

    print(''.join(S))
