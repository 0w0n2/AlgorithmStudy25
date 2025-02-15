n=int(input())
arr=list(map(int,input().split()))
new_arr=list(set(arr))
new_arr=sorted(new_arr)
dic={}
for i in range(len(new_arr)): #수업에서 배운 dat자료구조를 이용하면 간단함
    dic[new_arr[i]]=i        #다만 list.index(i)를 하면 시간초과가 남
                             #그래서 dict를 이용하여 시간복잡도를 줄인다!!
for i in arr:
    print(dic[i],end=" ")
