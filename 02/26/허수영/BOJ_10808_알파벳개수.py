arr=input()
result=[0] * 26
for i in  arr:
    result[ord(i)-97] +=1

for i in result:
    print(i,end=' ')
