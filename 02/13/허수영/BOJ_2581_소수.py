M=int(input())
N=int(input())
arr=[]
for i in range(M,N+1):
    if i ==1:
        continue
    for x in range(2,i):
        if i % x==0:
            break
    else:
        arr.append(i)
if len(arr)>0:
    print(sum(arr))
    print(min(arr))
else:
    print(-1)
