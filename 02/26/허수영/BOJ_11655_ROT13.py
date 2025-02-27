a=input()
result=''
for i in a:
    if i.isalpha():
        if(ord(i)>64 and ord(i)<78) or (ord(i)>96 and ord(i)<110):
            result+=chr(ord(i)+13)
        else:
            result+=chr(ord(i)-13)
    else:
        result+=i
print(result)