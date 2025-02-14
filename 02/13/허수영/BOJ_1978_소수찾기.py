n=int(input())
cnt=0
arrs=list(map(int,input().split()))
for arr in arrs:
    if arr==1:
        continue

    for x in range(2,arr):
        if arr % x ==0:
            break
    else:
        cnt+=1
print(cnt)
