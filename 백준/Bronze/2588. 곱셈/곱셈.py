A = int(input())
B = int(input())

B1 = B // 100
B2 = (B // 10) % 10
B3 = B % 10

print(A*B3)
print(A*B2)
print(A*B1)
print(A*B)