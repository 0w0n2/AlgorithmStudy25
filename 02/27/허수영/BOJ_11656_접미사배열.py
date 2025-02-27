a=input()
result=[]
for i in range (len(a)):
    result.append(a[i:])
    result.sort()
for i in result:
    print(i)
