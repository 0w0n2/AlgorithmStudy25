while True:
    arr=[]
    n=int(input())
    if n== -1:
        break
    else:
        for i in range(1,n):
            if n % i ==0:
                arr.append(i)

        total=sum(arr)

        if total == n:
            print(f'{n} = ' + ' + '.join(map(str,arr)))
        else:
            print(f'{n} is NOT perfect.')
