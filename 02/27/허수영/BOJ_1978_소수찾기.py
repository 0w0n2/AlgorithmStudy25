N=int(input())
arrs=list(map(int,input().split()))
cnt=0
for arr in arrs:
    if arr==1:
        continue
    for x in range(2,arr):
        if arr % x ==0:
            break
    else:
        cnt+=1
print(cnt)
