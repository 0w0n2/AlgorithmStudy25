import math
from itertools import combinations
t=int(input())

for _ in range(t):
    arr=list(map(int,input().split()))
    arr.pop(0)
    total=list(combinations(arr,2))
    ans=0
    for i in total:
        ans+=math.gcd(i[0],i[1])
    print(ans)


# 반복문 사용할때
# import math
# n=int(input())
# 
# for i in range(n):
#     arr=list(map(int,input().split()))
#     total=0
#     for j in range(1,len(arr)):
#         for k in range(j+1,len(arr)):
#             total+=math.gcd(arr[j],arr[k])
#     print(total)
