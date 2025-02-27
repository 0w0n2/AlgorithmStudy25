arr=input()
result=[-1]*26

for i in range(len(arr)):
    if result[ord(arr[i])-97] != -1:
        continue
    else:
        result[ord(arr[i])-97] =i
print(*result)

# arr=input()
#
# for x in 'abcdefghizklmnopqrstuvwxyz':
#     print(arr.find(x),end=' ')
#find를 이용하면 찾는 문자열 없으면 -1출력함!
