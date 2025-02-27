import sys
input=sys.stdin.readline
N=int(input())
# alphabet=list(map(chr,range(65,91)))
alphabet={}
arr=input().strip()

for i in range(N):
    alphabet[chr(65+i)]=int(input()) #alphabet이라는 딕셔너리에 알파벳별 값을 넣음
stack=[]
for i in arr:
    if i.isalpha():
        stack.append(alphabet[i])
       # i= int(input())
       # stack.append(i)

    elif i=='*':
        stack.append(stack.pop(-2)*stack.pop(-1))
    elif i=='+':
        stack.append(stack.pop(-2)+stack.pop(-1))
    elif i=='/':
        stack.append(stack.pop(-2)/stack.pop(-1))
    elif i=='-':
        stack.append(stack.pop(-2)-stack.pop(-1))

stack=stack[0]
print(f'{stack:.2f}')

