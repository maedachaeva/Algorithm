from sys import stdin

N = int(stdin.readline().strip())

for x in range(1, N + 1):
    print(' ' * (N - x) + '*' * x)
