N = int(input())
arr = []

for i in range(1, N+1):
    cnt = 0
    if len(str(i)) == 1:
        if i%3 == 0:
            arr.append('-')
        else:
            arr.append(i)
    else:
        for a in range(len(str(i))):
            if str(i)[a] in ['3', '6', '9']:
                cnt += 1

        if cnt == 1 or cnt == 2:
            arr.append('-'*cnt)
        else:
            arr.append(i)

print(*arr)
