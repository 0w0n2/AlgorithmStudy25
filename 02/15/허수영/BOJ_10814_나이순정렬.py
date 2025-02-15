n=int(input())
arr=[]
for _ in range(n):
    age,name=input().split()
    arr.append([int(age),name]) #순서대로 추가한다음
arr.sort(key=lambda x:int(x[0]))#그냥 나이순으로 정렬하면 나이순으로
                                #정렬 된 후 인덱스 정렬됨
for i in arr:
    print(i[0],i[1])
