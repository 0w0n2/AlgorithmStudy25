# while True:
#     try:
#         text_list=list(input())
#         lower,upper,num,blank=0,0,0,0
#         for i in range(len(text_list)):
#             if text_list[i]==" ":
#                 blank+=1
#             elif 65<=ord(text_list[i])<=90:
#                 upper+=1
#             elif 97<=ord(text_list[i])<=122:
#                 lower+=1
#             else:
#                 num+=1
#         print(lower,upper,num,blank)
#     except EOFError:
#         break

import sys
input=sys.stdin.readline
while True:
    arr=input().rstrip('\n')

    if not arr:
        break

    lower,upper,num,blank=0,0,0,0

    for i in arr:
        if i.islower():
            lower+=1
        elif i.isupper():
            upper+=1
        elif i.isdigit():
            num+=1
        else:
            blank+=1

    print(lower,upper,num,blank,sep=' ')
