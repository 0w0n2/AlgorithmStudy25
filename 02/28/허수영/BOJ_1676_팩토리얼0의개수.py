n=int(input())
result=1
cnt=0
for i in range(1,n+1):
    result*=i
result=str(result)
for i in range(1,len(result)+1):
    if result[-i]=='0':
        cnt+=1
    else:
        break
print(cnt)
