n=int(input())
result=0
for i in range(1,n+1):
    a=list(map(int,str(i))) #i를 문자열로 받아서 다시 인트로해서 합쳐서 자릿수 합치기
    result=sum(a)+i
    if result ==n:
        print(i)
        break
    if i==n:
        print(0)
