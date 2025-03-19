X = int(input())
N = int(input())

cost = 0

for i in range(N):
    a, b = map(int, input().split())
    cost += a * b

if X == cost:
    print("Yes")
else:
    print("No")