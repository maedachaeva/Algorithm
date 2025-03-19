N = int(input())
num = input().strip()

sum = 0

for _ in num:   # num 문자열의 각 문자를 하나씩 _ 변수에 할당
    sum += int(_)   # _ 문자를 형변환

print(sum)