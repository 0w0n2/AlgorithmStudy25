N = int(input())
dict = {'red': 1, 'orange': 2, 'yellow': 3, 'green': 4, 'blue': 5, 'purple': 6}

for _ in range(N):
    a, b = map(str, input().split())
    x, y = dict.get(a), dict.get(b)
    if x == y: print('E')  # get(a) : value값을 반환해줌
    elif abs(x-y) == 1 or abs(x-y) == 5: print('A')
    elif abs(x-y) == 3: print('C')
    else: print('X')
