T = int(input())
for tc in range(1, T+1):

    text = input()

    print(f'#{tc}', end=' ')
    if text == text[::-1]: print(1)
    else: print(0)
