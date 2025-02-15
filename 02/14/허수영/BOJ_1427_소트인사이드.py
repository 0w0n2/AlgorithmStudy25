n=int(input())
nums=list(map(int,str(n))) //str로 받아서 리스트로 받아야 정렬이가능함
nums.sort(reverse=True)
for i in nums:
    print(i,end=' ')
