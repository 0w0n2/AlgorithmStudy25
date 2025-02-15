n=int(input())
maps=[list(map(int,input().split())) for _ in range(n)]
maps.sort(key=lambda x:[x[0],x[1]]) #람다 x 이용해서 원하는대로 좌표 정렬
for i in maps:
    print(i[0],i[1])
