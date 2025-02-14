n=int(input())
arr=[]
for i in range(2,n+1):
    if n%i !=0:
        continue
    else:
        while n%i==0:
            print(i)
            n=n/i

