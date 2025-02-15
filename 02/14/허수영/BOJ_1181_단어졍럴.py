n=int(input())
words=[input() for _ in range(n)]
words=list(set(words)) #set으로 만들고 리스트로 다시만들어서 중복없앰
words.sort()   # 오름차순 정렬하고
words.sort(key=lambda x:len(x)) #거기서 다시 길이별로
# print(words)
for i in words:
    print(i)

