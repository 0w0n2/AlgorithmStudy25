n=int(input())
arr=[]
for x in range(n):     
    for y in range(n):
        if 3*x + 5*y ==n:    #그냥 연립방정식으로 값 구함
            arr.append(x+y)
if arr ==[]:
    print(-1)
else:
    print(min(arr))

# sugar=int(input())
# bag=0
# while sugar>=0:
#     if sugar % 5==0:  #5의 배수가 된다면 다 나눠버리고 그마큼 가방수 더함
#         bag+=(sugar//5)
#         print(bag)
#         break
#     sugar -=3 #sugar를 5의 배수로 만들기 위해 3을 빼주고
#     bag+=1
# else:
#     print(-1)
