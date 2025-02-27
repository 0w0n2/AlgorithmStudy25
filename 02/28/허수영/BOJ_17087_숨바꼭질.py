import math
n,s=map(int,input().split())
bros=list(map(int,input().split()))
result=[]
for i in range(n):
    result.append(abs(bros[i]-s))
print(math.gcd(*result))
