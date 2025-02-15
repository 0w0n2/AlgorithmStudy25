N,M=map(int,input().split())
maps=[list(map(str,input())) for _ in range (N)]
result=[]
for i in range(N-7):
    for j in range(M-7):
        count1=0
        count2=0
        #8*8크기로 map 자르기
        for x in range(i,i+8):
            for y in range(j,j+8):
                if (x+y)%2==0: #첫시작을 검은색으로할떄
                    if maps[x][y]!='B':
                        count1+=1
                    if maps[x][y]!='W':
                        count2+=1
                else:           #첫 시작을 흰색 으로 할때
                    if maps[x][y]!='W':
                        count1+=1
                    if maps[x][y]!='B':
                        count2+=1
        result.append(count1) #2개를 전부 구하고
        result.append(count2)
print(min(result))  #최솟값 선택하면 최소로 변하게 하는 거
