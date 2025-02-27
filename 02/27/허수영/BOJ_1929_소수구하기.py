# import math
# N,M=map(int,input().split())
# for arrs in range(N,M+1):
#     if arrs==1:
#        continue
#
#     for arr in range(2,int(math.sqrt(arrs)+1)):
#         if arrs % arr ==0:
#             break
#     else:
#         print(arrs)



#에라토스테네스의 체
import math

n,m=map(int,input().split())
arr=[True for i in range(m+1)]

for i in range(2,int(math.sqrt(m))+1):
    if arr[i] == True:
        j=2
        while i*j <=m:
            arr[i*j] = False
            j+=1
for i in range(n,m+1):
    if i==1:
        continue
    elif arr[i]:
        print(i)
