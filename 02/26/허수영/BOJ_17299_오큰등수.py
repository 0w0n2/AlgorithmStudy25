import sys
input=sys.stdin.readline
N=int(input())
arr=list(map(int,input().split()))
result=[-1]*N
dat=[0]*1000001
stack=[0]

for i in range(len(arr)):
    dat[arr[i]]+=1

for i in range(1,N):
    while stack and dat[arr[stack[-1]]] < dat[arr[i]]:
        result[stack.pop()]=arr[i]
    stack.append(i)
print(*result)
